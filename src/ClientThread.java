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

    int conuter;
    boolean win;
    ChangeColor changeColor = new ChangeColor();

    private boolean gameIsRunning = true;

    ClientThread(PrintWriter writer, BufferedReader reader){
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

            String shotOut = fireOutput(XRowValue,YRowValue);
            writer.println(shotOut);
            System.out.println("out " + shotOut);

            coordinat = breakOut(shotOut);

            //backEndMap.delyTheGame();

            String shotIn = null;
            try {
                shotIn = reader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            if (shotIn.equals("game over")){
                controllIflose();
                break;
            }
            fireInput(shotIn);

            System.out.println("In " + shotIn);

            String tempStatu = shotIn.substring(0,1);

            if (tempStatu.equals("h")){
                conuter++;
            }

            changeArray(coordinat,tempStatu);
            changeColor.colorChangesEnemy(coordinat);
            changeColor.colorChangesYour(shotIn);

            controllIfwin();

        }

    }
}
