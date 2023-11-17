package FrontEnd;

import BackEnd.Ship;
import BackEnd.SystemBoard;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fire implements SystemBoard {
    Ship ship = new Ship();
    Random random = new Random();
    private String YRow;
    private int YRowInt;
    private int indexX;
    private int indexY;
    private String shotFire;
    private int count = 0;
    //en lista på alla skot som har skjutis (AR)
    private List<String> listOfShot = new ArrayList<>();
    private String shotStatus = "i";
    private String coordinat;

    public String shipUnder = " hej";

    // Skapar en random Sträng av två int värden som har en ett random värde. (AR , FK)
    public String fireOutput(int x, int y) {
        boolean isFiring = true;
        while (isFiring) {
            indexX = random.nextInt(x);
            indexY= random.nextInt(y);

            convertIntToString(indexY);
            String shotCoordinat = String.join("",String.valueOf(indexX), String.valueOf(indexY));

            shotFire = String.join("",shotStatus, " shot ", String.valueOf(indexX), YRow);
            if (!listOfShot.contains(shotCoordinat)) {
                listOfShot.add(shotCoordinat);
                count++;
                isFiring = false;
            }
        }
        return shotFire;
    }


    public void fireInput(String shotInput) {
        int valueX = Character.getNumericValue(shotInput.charAt(7));
        int valueY = covertYCharToYint((shotInput.charAt(8)));
        String tom = "";
        if (array[valueX][valueY].equals("s")) {
            String shipControl = ship.hitShipCoordinate(valueX,valueY);
            array[valueX][valueY] = "h";
            tom = "h";
            if (!shipControl.equals("v")){
                tom = "s";
                shipUnder = "Ett helt sjäp har träffas";
                //System.out.println("Ett helt sjäp har träffas");
            }
        }
        else {
            array[valueX][valueY] = "m";
            tom = "m";
        }
         shotStatus = tom;
    }

    public Ship getShip(){
        return ship;
    }
    public void changeEnemyArray(String shotCoordinat, String temp){
        if ( shotCoordinat == null){

        }
        else {
            int valueX = Character.getNumericValue(shotCoordinat.charAt(0));
            int valueY = Character.getNumericValue(shotCoordinat.charAt(1));
            if (temp.equals("h") || temp.equals("s")) {
                arrayEnemy[valueX][valueY] = "h";
            } else if (temp.equals("m")) {
                arrayEnemy[valueX][valueY] = "m";

            }
        }

    }
    public String convertIntToString(int y){
        if (y == 0){
            YRow = "a";
            return YRow;
        }
        else if (y == 1){
            YRow = "b";
            return YRow;
        }
        else if (y == 2){
            YRow = "c";
            return YRow;
        }
        else if (y == 3){
            YRow = "d";
            return YRow;
        }
        else if (y == 4){
            YRow = "e";
            return YRow;
        }
        else if (y == 5){
            YRow = "f";
            return YRow;
        }
        else if (y == 6){
            YRow = "g";
            return YRow;
        }
        else if (y == 7){
            YRow = "h";
            return YRow;
        }
        else if (y == 8){
            YRow = "i";
            return YRow;
        }
        else {
            YRow = "j";
            return YRow;
        }
    }

    public int covertYCharToYint(char y){
        if (y == 'a'){
            YRowInt = 0;
            return YRowInt;
        }
        else if (y == 'b'){
            YRowInt = 1;
            return YRowInt;
        }
        else if (y == 'c'){
            YRowInt = 2;
            return YRowInt;
        }
        else if (y == 'd'){
            YRowInt = 3;
            return YRowInt;
        }
        else if (y == 'e'){
            YRowInt = 4;
            return YRowInt;
        }
        else if (y == 'f'){
            YRowInt = 5;
            return YRowInt;
        }
        else if (y == 'g'){
            YRowInt = 6;
            return YRowInt;
        }
        else if (y == 'h'){
            YRowInt = 7;
            return YRowInt;
        }
        else if (y == 'i'){
            YRowInt = 8;
            return YRowInt;
        }
        else {
            YRowInt = 9;
            return YRowInt;
        }
    }

    public String breakOut (String breakOut){
        String temp;
        int valueX = Character.getNumericValue(breakOut.charAt(7));
        int valueY = covertYCharToYint((breakOut.charAt(8)));
        temp = String.join("", String.valueOf(valueX), String.valueOf(valueY));
        return temp;
    }

    public String getCoordinat() {
        return coordinat;
    }

    public void setCoordinat(String coordinat) {
        this.coordinat = coordinat;
    }

    public String getShotStatus() {
        return shotStatus;
    }
}
