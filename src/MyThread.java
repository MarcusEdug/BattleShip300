import BackEnd.BackEndMap;
import BackEnd.Ship;
import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;

import java.io.IOException;
import java.util.Scanner;

public class MyThread implements Runnable, SystemBord {
    //Kan "extend" en annan klass om det behövs
    BackEndMap backEndMap = new BackEndMap();
    Fire shotFire = new Fire();
    ChangeColor changeColor = new ChangeColor();

    String test ="s";
    Scanner myScanner = new Scanner(System.in);

    Ship ship;
    @Override
    public void run()  {
        backEndMap.createEndMap(XRowValue,YRowValue);
        ship = new Ship();
        ship.createShipUnits();
        //System.out.println("båtar skapade");
        try{

            ship.placeShipsOnMap(array);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //System.out.println("Nu är dom placerade");
        backEndMap.showEndMap(XRowValue,YRowValue);
        while (!ship.checkActiveShips()) {
            String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
            //System.out.println("De har skjutist");
            int valueX = Character.getNumericValue(shipFire.charAt(0));
            int valueY = Character.getNumericValue(shipFire.charAt(1));
            ship.hitShipCoordinate(valueX,valueY);
            //System.out.println("nu har ship tagit emot skottet");
            shotFire.fireInput(shipFire);
            //System.out.println("nu har fireinput tagit emot skottet");
            changeColor.colorChanges(valueX,valueY);
            //System.out.println("nu ändras färgen");
            backEndMap.showEndMap(XRowValue,YRowValue);
        }
        System.out.println("Won");
        //Kör  hela BackEnd programet (AR)

    }
    public void runBackEnd() {
        backEndMap.createEndMap(XRowValue,YRowValue);
        ship = new Ship();
        ship.createShipUnits();
        //System.out.println("båtar skapade");
        try{

            ship.placeShipsOnMap(array);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //System.out.println("Nu är dom placerade");
        backEndMap.showEndMap(XRowValue,YRowValue);
        while (!ship.checkActiveShips()) {
            String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
            //System.out.println("De har skjutist");
            int valueX = Character.getNumericValue(shipFire.charAt(0));
            int valueY = Character.getNumericValue(shipFire.charAt(1));
            ship.hitShipCoordinate(valueX,valueY);
            //System.out.println("nu har ship tagit emot skottet");
            shotFire.fireInput(shipFire);
            //System.out.println("nu har fireinput tagit emot skottet");
            changeColor.colorChanges(valueX,valueY);
            //System.out.println("nu ändras färgen");
            backEndMap.showEndMap(XRowValue,YRowValue);
        }
        System.out.println("Won");



    }
    public void hitInput (){
        String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
        int valueX = Character.getNumericValue(shipFire.charAt(0));
        int valueY = Character.getNumericValue(shipFire.charAt(1));
        ship.hitShipCoordinate(valueX,valueY);
        shotFire.fireInput(shipFire);
        changeColor.colorChanges(valueX,valueY);


    }
}
