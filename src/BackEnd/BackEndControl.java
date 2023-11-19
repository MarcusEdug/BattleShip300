package BackEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BackEndControl implements SystemBoard {
    private Ship ship = new Ship();
    private Random random = new Random();
    private String YRow;
    private int YRowInt;
    private int indexX;
    private int indexY;
    private String shotFire;
    private int count = 0;
    private List<String> listOfShot = new ArrayList<>();
    private String shotStatus = "i";
    private String coordinat;

    //Metod:Slumpar en koordinat och skickar iväg en sträng. Den kontrollerar att man skickar ut en unik sträng varje gång (AR, FK, MS, ED)
    public String fireOutput(int x, int y) {
        boolean isFiring = true;
        while (isFiring) {
            indexX = random.nextInt(x);
            indexY= random.nextInt(y);

            convertIntToString(indexY);
            String shotCoordinate = String.join("",String.valueOf(indexX), String.valueOf(indexY));

            shotFire = String.join("",shotStatus, " shot ", String.valueOf(indexX), YRow);
            if (!listOfShot.contains(shotCoordinate)) {
                listOfShot.add(shotCoordinate);
                count++;
                isFiring = false;
            }
        }
        return shotFire;
    }

    //Metod: Tar in strängvärde och ändrar sin egna karta och spara status på tidigare skott (ED, FK, MS, AR)
    public void fireInput(String shotInput) {
        int valueX = Character.getNumericValue(shotInput.charAt(7));
        int valueY = covertYCharToYint((shotInput.charAt(8)));
        String tom = "";
        if (arrayYours[valueX][valueY].equals("s")) {
            String shipControl = ship.hitShipCoordinate(valueX,valueY);
            arrayYours[valueX][valueY] = "h";
            tom = "h";
            if (!shipControl.equals("v")){
                tom = "s";
                //System.out.println("Ett helt skepp har träffas");
            }
        }
        else {
            arrayYours[valueX][valueY] = "m";
            tom = "m";
        }
         shotStatus = tom;
    }

    //Metod: Upprättar backend karta för fienden och för sig själv (AR)
    public void createEndMap(int XRowValue, int YRowValue){
        for (int y = 0; y < XRowValue; y++) {
            for (int x = 0; x < YRowValue; x++) {
                arrayYours[y][x] = "i";
                arrayEnemy[y][x] = "i";
            }
        }
    }

    //Metod: Skapar en delay (FK, MS, ED, AR, FN)
    public void delyTheGame(int delay){
        if(delay == 0){
            try {
                Thread.sleep(0);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else {
            try {
                Thread.sleep(delay * 100);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    //Metod: Ändra fiendens karta efter skott koordinat och status på sitt tidigare skott (MS, ED, AR, FK)
    public void changeEnemyArray(String shotCoordinate, String status){
        if ( shotCoordinate == null){

        }
        else {
            int valueX = Character.getNumericValue(shotCoordinate.charAt(0));
            int valueY = Character.getNumericValue(shotCoordinate.charAt(1));
            if (status.equals("h") || status.equals("s")) {
                arrayEnemy[valueX][valueY] = "h";
            } else if (status.equals("m")) {
                arrayEnemy[valueX][valueY] = "m";

            }
        }

    }

    //Metod: Omvandlar int till string (AR, ED, MS, FK)
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

    //Metod: Omvandlar char till int (FK, MS, ED, AR)
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

    //Metod Tar ut koordinater utifrån en sträng (AR, MS, ED FK)
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

    public Ship getShip(){
        return ship;
    }
}
