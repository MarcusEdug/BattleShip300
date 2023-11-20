package ServerAndClient;

import BackEnd.SystemBoard;
import FrontEnd.ChangeColor;
import BackEnd.BackEndControl;
import FrontEnd.GameBoardLayout;
import FrontEnd.StartEndScreens;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerThread extends BackEndControl implements Runnable, SystemBoard {
    private PrintWriter writer;
    private BufferedReader reader;
    private GameBoardLayout gameBoardLayout = new GameBoardLayout();
    private Stage stage;
    private ChangeColor changeColor = new ChangeColor();

    private int counter;
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

    //Metod: Gör att spelet slutar och visar vinnst i end fönstret som kommer upp (ED)
    public void controllIfwin(){
        if(counter == 30){

            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            StartEndScreens.endplay(win, stage);
        }
    }
    //Metod: Gör att spelet slutar och vissar förlust i end fönstret som kommer upp (ED)
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


        if (gameIsRunning) {
            getShip().createShipUnits();
            getShip().placeShipsOnMap(arrayYours);
            //Skapa och sätt ut skepp på din backend karta

            changeColor.clientYourMapsColor();
            //Sätt ut skeppen på din egna FX karta

            try {
                shotIn = reader.readLine();
                //Ta emot ett skott från Clienten

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fireInput(shotIn);
            //Här får vi en status på tidigare skott
            //Här ändras våra egna karta efter skottet
            delyTheGame(delay);


        }
        while (gameIsRunning) {

            changeColor.colorChangesYour(shotIn);
            System.out.println("Client skicka : " + shotIn);

            //Här uppdattera vi våra egna FX karta efter skottet som kom in

            delyTheGame(delay);
            //Sätt en delay på spelet

            shotOut = fireOutput(XRowValue,YRowValue);
            System.out.println("Server skicka : " + shotOut);
            System.out.println(" ");
            writer.println(shotOut);
            //Här skjutter vi på Clienten och vi skickar iväg status på skottet som vi tidigare fick

            setCoordinat(breakOut(shotOut));
            //Vi spara koordinaterna på skott

            try {
                shotIn = reader.readLine();
                //Ta emot ett skott från Clienten


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ( shotIn.equals("game over")){
                //vi kollar ifall man har förlorat
                controllIflose();
                break;
            }
            else {
                fireInput(shotIn);
                gameBoardLayout.changeText(getShotStatus());

                //Här får vi status på våra skott som vi skött
                //Sin egna karta ändra efter skottet

                String tempStatu = shotIn.substring(0, 1);
                //här tar vi ut vad för status våra skott hade

                changeEnemyArray(getCoordinat(), tempStatu);
                //här ändra vi våran fiende backend karta

                changeColor.colorChangesEnemy(getCoordinat());
                //Här uppdatar vi FX kartan för fienden


                if (tempStatu.equals("h")||tempStatu.equals("s")) {
                    counter++;
                    //Håller räkningen på hur många gånger vi träffar
                }
                controllIfwin();
                //kollar ifall vi har vunnit
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
