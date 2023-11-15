import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ServerThread extends Fire implements Runnable, SystemBord {
    PrintWriter writer;
    BufferedReader reader;

    ChangeColor changeColor = new ChangeColor();

    private boolean gameIsRunning = true;

    int conuter;
    boolean win;

    ServerThread(PrintWriter writer, BufferedReader reader){
        this.writer = writer;
        this.reader = reader;
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
        changeColor.clientColor();
        while (gameIsRunning) {
            //System.out.println("inne i tråden");

            String shotIn = null;
            try {
                shotIn = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (shotIn.equals("game over")){
                controllIflose();
                break;
            }
            fireInput(shotIn);

            System.out.println("In " + shotIn);



            //backEndMap.delyTheGame();

            String shotOut = fireOutput(XRowValue,YRowValue);
            writer.println(shotOut);
            System.out.println("out " + shotOut);

            coordinat = breakOut(shotOut);

            String tempStatu = shotIn.substring(0,1);
            if (tempStatu.equals("h")){
                conuter++;
            }
            changeArray(coordinat, tempStatu);
            changeColor.colorChangesYour(shotIn);
            changeColor.colorChangesEnemy(coordinat);

            controllIfwin();
        }

    }
}
