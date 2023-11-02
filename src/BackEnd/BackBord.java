package BackEnd;

import java.util.Scanner;

public class BackBord implements SystemBord{
    private boolean playGame = true;
    Scanner myScanner = new Scanner(System.in);
    BackEndMap backEndMap = new BackEndMap();

    public void runBackEnd() {
        backEndMap.createEndMap(XRowValue,YRowValue);
        backEndMap.bout51();
       // backEndMap.bout52();
        System.out.println(lifeOnBoat.size());
        backEndMap.showEndMap(XRowValue,YRowValue);
        while (!lifeOnBoat.isEmpty()) {
                 //backEndMap.hitInput();
            backEndMap.fire();
            //backEndMap.showEndMap(XRowValue,YRowValue);
        }
        System.out.println("Won");

        }
    }
