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

public class ServerThread extends Fire implements Runnable, SystemBoard {
    private PrintWriter writer;
    private BufferedReader reader;
    private GameBoardLayout gameBoardLayout = new GameBoardLayout();
    private Stage stage;
    private ChangeColor changeColor = new ChangeColor();
    private BackEndMap backEndMap = new BackEndMap();

    private int conuter;
    private boolean win;
    private int delay;
    private boolean gameIsRunning = true;

    public ServerThread(PrintWriter writer, BufferedReader reader, GameBoardLayout gameBoardLayout, Stage stage){
        this.writer = writer;
        this.reader = reader;
        this.gameBoardLayout = gameBoardLayout;
        this.stage = stage;
    }
    public ServerThread(){}

    public void controllIfwin(){
        if(conuter == 30){

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

            backEndMap.delyTheGame(delay);

            shotOut = fireOutput(XRowValue,YRowValue);
            System.out.println("Server skicka : " + shotOut);
            writer.println(shotOut);
            //Här Skjutter vi på en sluppmässig punkt

            setCoordinat(breakOut(shotOut));


            //Här spara vi punkten som vi skött på

            try {
                shotIn = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ( shotIn.equals("game over")){
                controllIflose();
                break;
            }
            else {
                //här ta vi emot skottet

                fireInput(shotIn);
                gameBoardLayout.changeText(getShotStatus());

                //Här får vi status på våra skott som vi skött
                //Våra egna karta ändra efter skottet

                String tempStatu = shotIn.substring(0, 1);


                //här tar vi ut vad för status våra skott hade

                //Här håller vi koll på hur oftas vi träffar

                changeEnemyArray(getCoordinat(), tempStatu);
                //här ändra vi våran fiende karta

                changeColor.colorChangesEnemy(getCoordinat());
                //Här uppdatar vi FX kartan för fienden


                if (tempStatu.equals("h")||tempStatu.equals("s")) {
                    conuter++;
                    System.out.println(conuter);
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
