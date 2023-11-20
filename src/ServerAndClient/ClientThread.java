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

public class ClientThread extends BackEndControl implements Runnable, SystemBoard {
    private PrintWriter writer;
    private BufferedReader reader;
    private GameBoardLayout gameBoardLayout = new GameBoardLayout();
    private Stage stage;
    private ChangeColor changeColor = new ChangeColor();

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

    //Metod: Gör att spelet slutar och visar vinst i end fönstret som kommer upp (ED)
    public void controllIfwin(){
        if(counter == 30){
            win = true;
            gameIsRunning = false;
            writer.println("game over");
            System.out.println("You won");
            StartEndScreens.endplay(win, stage);
        }
    }
    //Metod: Gör att spelet slutar och visar förlust i end fönstret som kommer upp (ED)
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


        if(gameIsRunning) {
            getShip().createShipUnits();
            getShip().placeShipsOnMap(arrayYours);
            //Skapar och sätter ut skepp

            changeColor.changeYourMapColor();
            //Ändra din FX karta

            shotOut = fireOutput(XRowValue, YRowValue);
            writer.println(shotOut);
            System.out.println("Client sent : " + shotOut);
            System.out.println(" ");
            //Skjutter iväg ett skott mot Serven

            setCoordinat(breakOut(shotOut));
            //Spara koordinater för skottet som sköts
        }

        while (gameIsRunning) {

            try {
                shotIn = reader.readLine();
                //tar in info från Serven
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ( shotIn.equals("game over")){
                System.out.println("Server sent : " + shotIn);
                controllIflose();
                //Kollar om man har förlorat
                break;
            }
            else {
                fireInput(shotIn);
                //Läser av skott som kom in
                //Ändra sin egna karta
                //skapar en status på skottet

                gameBoardLayout.changeText(getShotStatus());
                //Om en båt har sänkts så skrivs det ut på FX kartan

                System.out.println("Server sent : " + shotIn);


                changeColor.colorChangesYour(shotIn);
                //ändrar färg på din egna FX karta

                String tempStatu = shotIn.substring(0, 1);
                //Bryter ut statusen ifrån inkommande skott och sparar den

                changeEnemyArray(getCoordinat(), tempStatu);
                // Ändra backend kartan för fienden

                changeColor.colorChangesEnemy(getCoordinat());
                //Ändra FX kartan för fienden

                if (tempStatu.equals("h")||tempStatu.equals("s")) {
                    counter++;
                    //räkna hur många träffa som man har gjort
                    controllIfwin();
                    //Kolla ifall man har vunnit
                }

                if (counter != 30) {
                    delyTheGame(delay);
                    //Sätt en delay på spelet

                    shotOut = fireOutput(XRowValue, YRowValue);
                    System.out.println("Client sent : " + shotOut);
                    System.out.println(" ");
                    writer.println(shotOut);
                    //Skjuter iväg ett skott
                    // som innehåller resultat på skottet som fienden skött och koordinater på mitt egna skott

                    setCoordinat(breakOut(shotOut));
                    //Ta ut koordinaterna för skottet som skickades iväg och spara den
                }
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
