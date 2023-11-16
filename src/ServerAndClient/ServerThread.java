package ServerAndClient;

import BackEnd.BackEndMap;
import BackEnd.Ship;
import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;
import FrontEnd.StartSkärm;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerThread extends Fire implements Runnable, SystemBord {
    PrintWriter writer;
    BufferedReader reader;

    private int delay;
    Stage stage;

    ChangeColor changeColor = new ChangeColor();

    BackEndMap backEndMap = new BackEndMap();

    int conuter;
    boolean win;

    private boolean gameIsRunning = true;
    //Ship ship = new Ship();

    //BackEndMap backEndMap = new BackEndMap();



    public ServerThread(PrintWriter writer, BufferedReader reader, Stage stage){
        this.writer = writer;
        this.reader = reader;
        //this.delay = delay;
        this.stage = stage;
    }
    public ServerThread(){

    }

    public void controllIfwin(){
        if(conuter == 30){

            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            StartSkärm.endplay(win, stage);
            //ändra JavaFX
        }
    }
    public void controllIflose(){
        win = false;
        gameIsRunning = false;
        System.out.println("You lost");
        StartSkärm.endplay(win, stage);
        //ändra JavaFX
    }



    @Override
    public void run() {
        String shotOut = "";
        String shotIn = "";
        backEndMap.createEndMap(XRowValue,YRowValue);

        if (gameIsRunning) {
            getShip().createShipUnits();
            getShip().placeShipsOnMap(array);

            System.out.println("Vi har skapa ship och 2d array");
            changeColor.clientColor();


            try {
                shotIn = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fireInput(shotIn);
            //Här får vi ett status
            //Här ändras våra egna karta efter vad som hände av skottet
            //Status på vad som hände av de här skottet

        }
        while (gameIsRunning) {
            changeColor.colorChangesYour(shotIn);
            System.out.println("Client skicka : " + shotIn);
            //Här uppdattera vi våra egna FX karta efter skottet som kom in

            backEndMap.delyTheGame(0);

            shotOut = fireOutput(XRowValue,YRowValue);
            System.out.println("Server skicka : " + shotOut);
            writer.println(shotOut);
            //Här Skjutter vi på en sluppmässig punkt

            coordinat = breakOut(shotOut);
            //Här spara vi punkten som vi skött på

            try {
                shotIn = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ( shotIn.equals("game over")){
                controllIflose();
            }
            else {
                //här ta vi emot skottet

                fireInput(shotIn);
                //Här får vi status på våra skott som vi skött
                //Våra egna karta ändra efter skottet

                String tempStatu = shotIn.substring(0, 1);
                //här tar vi ut vad för status våra skott hade

                //Här håller vi koll på hur oftas vi träffar

                changeArray(coordinat, tempStatu);
                //här ändra vi våran fiende karta

                changeColor.colorChangesEnemy(coordinat);
                //Här uppdatar vi FX kartan för fienden

                if (tempStatu.equals("h")||tempStatu.equals("s")) {
                    conuter++;
                    System.out.println(conuter);
                }
                //backEndMap.delyTheGame(0);
                controllIfwin();
            }
            //här en delay



            /*
            System.out.println("jag skicka ut  " + shotOut);
            coordinat = breakOut(shotOut);
            String tempStatu = shotIn.substring(0,1);

            try {
                shotIn = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (shotIn.equals("game over")){
                controllIflose();
                break;
            }

            System.out.println("jag tog in " + shotIn);

            backEndMap.delyTheGame(2);



            if (tempStatu.equals("h")){
                conuter++;
            }


            changeColor.colorChangesEnemy(coordinat);
            System.out.println("Jag har ändra enemy kart till C: " + coordinat + " Stats: " + tempStatu );


            changeColor.colorChangesYour(shotIn);

             */



        }

    }
}
