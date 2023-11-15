package ServerAndClient;

import BackEnd.BackEndMap;
import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientThread extends Fire implements Runnable, SystemBord {
    //Kan "extend" en annan klass om det behövs.

    PrintWriter writer;
    BufferedReader reader;

    ChangeColor changeColor = new ChangeColor();

    BackEndMap backEndMap = new BackEndMap();

    int conuter;
    boolean win;

    private boolean gameIsRunning = true;

    public ClientThread(PrintWriter writer, BufferedReader reader){
        this.writer = writer;
        this.reader = reader;
    }

    public ClientThread(){

    }
    public void controllIfwin(){
        if(conuter == 30){
            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            //ändra JavaFX
        }
    }
    public void controllIflose(){
        win = false;
        gameIsRunning = false;
        System.out.println("You lost");
        //ändra JavaFX
    }

    @Override
    public void run() {
        backEndMap.createEndMap(XRowValue,YRowValue);

        getShip().createShipUnits();
        System.out.println("har jag fastnat!");
        getShip().placeShipsOnMap(array);

        System.out.println("Vi har skapa ship och 2d array");
        changeColor.clientColor();

        String shotOut = fireOutput(XRowValue,YRowValue);
        writer.println(shotOut);

        coordinat = breakOut(shotOut);
        //Spara koordinater för skottet som skjötts

        while (gameIsRunning) {

            String shotIn = null;
            try {
                shotIn = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ( shotIn.equals("game over")){
                controllIflose();
            }
            else {
                fireInput(shotIn);
                //Läser av skott som kom in
                //Ändra sin egna karta
                //skapar en status på skottet

                changeColor.colorChangesYour(shotIn);
                //ändra färg på din egna FX karta

                String tempStatu = shotIn.substring(0, 1);
                //Bryter ut statusen

                changeArray(coordinat, tempStatu);
                // Ändra kartan för fienden

                changeColor.colorChangesEnemy(coordinat);
                //Ändra FX kartan för fienden

                shotOut = fireOutput(XRowValue, YRowValue);
                writer.println(shotOut);
                //Skjutter iväg ett skott
                // som innehåller resultat på skottet som fienden skött och koordinater på mitt egna skott

                coordinat = breakOut(shotOut);

                if (tempStatu.equals("h")||tempStatu.equals("s")) {
                    conuter++;
                    System.out.println(conuter);
                }
                controllIfwin();
            }
            //Spara koordinater för skottet som skjötts

            //System.out.println("jag skicka ut  " + shotOut);


            /*coordinat = breakOut(shotOut);

            //backEndMap.delyTheGame(2);

            if (shotIn.equals("game over")){
                controllIflose();
                break;
            }
            fireInput(shotIn);
            System.out.println("jag tog in " + shotIn);



            String tempStatu = shotIn.substring(0,1);

            if (tempStatu.equals("h")){
                conuter++;
            }

            changeArray(coordinat,tempStatu);
            System.out.println("Jag har ändra enemy kart till C: " + coordinat + " Status: " + tempStatu );
            changeColor.colorChangesYour(shotIn);
            changeColor.colorChangesEnemy(coordinat);

             */



        }

    }
}
