package ServerAndClient;

import BackEnd.BackEndMap;
import BackEnd.SystemBoard;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;
import FrontEnd.GameBoardLayout;
import FrontEnd.StartEndScreens;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientThread extends Fire implements Runnable, SystemBoard {
    private PrintWriter writer;
    private BufferedReader reader;
    private GameBoardLayout gameBoardLayout = new GameBoardLayout();
    private Stage stage;
    private ChangeColor changeColor = new ChangeColor();
    private BackEndMap backEndMap = new BackEndMap();

    private int counter;
    private boolean win;
    private int delay;
    private boolean gameIsRunning = true;

    public ClientThread(PrintWriter writer, BufferedReader reader,GameBoardLayout gameBoardLayout, Stage stage){
        this.writer = writer;
        this.reader = reader;
        this.gameBoardLayout = gameBoardLayout;
        this.stage = stage;

    }
    public ClientThread(){
    }

    public void controllIfwin(){
        if(counter == 30){
            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            StartEndScreens.endplay(win, stage);
        }
    }
    public void controllIflose(){
        win = false;
        gameIsRunning = false;
        System.out.println("You lost");
        StartEndScreens.endplay(win, stage);
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
                    counter++;
                    System.out.println(counter);
                }
                controllIfwin();
            }
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
