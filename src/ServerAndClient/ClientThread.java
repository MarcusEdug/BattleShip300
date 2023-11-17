package ServerAndClient;

import BackEnd.BackEndMap;
import BackEnd.SystemBoard;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;
import FrontEnd.GameBoardLayout;
import FrontEnd.StartEndScreens;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientThread extends Fire implements Runnable, SystemBoard {
    //Kan "extend" en annan klass om det behövs.

    PrintWriter writer;
    BufferedReader reader;



    GridPane gridPane = new GridPane();
    GameBoardLayout gameBoardLayout = new GameBoardLayout();

    private int delay;

    Stage stage;

    ChangeColor changeColor = new ChangeColor();

    BackEndMap backEndMap = new BackEndMap();

    int conuter;
    boolean win;

    private boolean gameIsRunning = true;

    /*public ClientThread(PrintWriter writer, BufferedReader reader, Stage stage){
        this.writer = writer;
        this.reader = reader;
        //this.delay = delay;
        this.stage = stage;
        this.gameBoardLayout = gameBoardLayout;
    }

     */



    public ClientThread(PrintWriter writer, BufferedReader reader,GameBoardLayout gameBoardLayout, Stage stage){
        this.writer = writer;
        this.reader = reader;
        this.gameBoardLayout = gameBoardLayout;
        this.stage = stage;

    }
    public ClientThread(){

    }
    public void controllIfwin(){
        if(conuter == 30){
            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            StartEndScreens.endplay(win, stage);
            //ändra JavaFX
        }
    }
    public void controllIflose(){
        win = false;
        gameIsRunning = false;
        System.out.println("You lost");
        StartEndScreens.endplay(win, stage);
        //ändra JavaFX
    }

    @Override
    public void run() {
        String shotOut = "";
        String shotIn = "";

        backEndMap.createEndMap(XRowValue,YRowValue);
        if(gameIsRunning) {
            getShip().createShipUnits();
            getShip().placeShipsOnMap(array);

            System.out.println("Vi har skapa ship och 2d array");
            changeColor.clientColor();

            shotOut = fireOutput(XRowValue, YRowValue);
            writer.println(shotOut);
            System.out.println("Client skicka : " + shotOut);
            System.out.println(" ");

            setCoordinat(breakOut(shotOut));
            //Spara koordinater för skottet som skjötts
        }

        while (gameIsRunning) {

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

                gameBoardLayout.changeText(getShotStatus());

                System.out.println("Server skicka : " + shotIn);
                //Läser av skott som kom in
                //Ändra sin egna karta
                //skapar en status på skottet

                changeColor.colorChangesYour(shotIn);
                //ändra färg på din egna FX karta

                String tempStatu = shotIn.substring(0, 1);
                //Bryter ut statusen




                changeEnemyArray(getCoordinat(), tempStatu);
                // Ändra kartan för fienden

                changeColor.colorChangesEnemy(getCoordinat());
                //Ändra FX kartan för fienden

                backEndMap.delyTheGame(delay);

                shotOut = fireOutput(XRowValue, YRowValue);
                System.out.println("Client skicka : " + shotOut);
                System.out.println(" ");
                writer.println(shotOut);
                //Skjutter iväg ett skott
                // som innehåller resultat på skottet som fienden skött och koordinater på mitt egna skott

                setCoordinat(breakOut(shotOut));

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

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
