import BackEnd.SystemBord;
import FrontEnd.Fire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientThread extends Fire implements Runnable, SystemBord {
    //Kan "extend" en annan klass om det behövs.

    PrintWriter writer;
    BufferedReader reader;

    private boolean gameIsRunning = true;

    ClientThread(PrintWriter writer, BufferedReader reader){
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (gameIsRunning) {
            System.out.println("inne i tråden");

            String shotOut = fireOutput(XRowValue,YRowValue);
            writer.println(shotOut);
            System.out.println("out " + shotOut);

            //backEndMap.delyTheGame();

            String shotIn = null;
            try {
                shotIn = reader.readLine();
                fireInput(shotIn);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("In " + shotIn);

            Scanner my = new Scanner(System.in);
            System.out.println("skriv");
            int test = my.nextInt();
            if (test == 1){
                gameIsRunning = false;
            }
        }

    }
}
