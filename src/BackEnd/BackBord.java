package BackEnd;

import java.util.Scanner;

public class BackBord implements SystemBord{
    private boolean playGame = true;
    Scanner myScanner = new Scanner(System.in);
    BackEndMap backEndMap = new BackEndMap();
    public void runBackEnd() {
        backEndMap.createEndMap(XRowValue,YRowValue);
        backEndMap.bout51();
        while (playGame) {
            backEndMap.showEndMap(XRowValue,YRowValue);
            String play = myScanner.nextLine();
            if (play.equals("hit")) {
                System.out.println("vart skjuter du?");
                String hit = myScanner.nextLine();
                backEndMap.hitInput(hit);
            } else if (play.equals("end")) {
                playGame = false;

            }
        }
    }
    }
