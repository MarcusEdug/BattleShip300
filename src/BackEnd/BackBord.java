package BackEnd;

import java.util.Scanner;

public class BackBord implements SystemBord{
    boolean playGame = true;
    Scanner myScanner = new Scanner(System.in);
    Hit hit = new Hit();
    BackEndMap backEndMap = new BackEndMap();

    public void backBord() {
        backEndMap.endMap(XRowValue,YRowValue);
        while (playGame) {
            backEndMap.showEndMap(XRowValue,YRowValue);
            String play = myScanner.nextLine();
            if (play.equals("hit")) {
                backEndMap.hit("7c");
            } else if (play.equals("end")) {
                playGame = false;

            }
        }
    }
    }
