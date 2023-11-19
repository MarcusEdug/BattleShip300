package FrontEnd;

import BackEnd.SystemBoard;
import javafx.scene.paint.Color;

public class ChangeColor implements SystemBoard {

    private int YRowInt;

    //Metod: Ändra färgen på FX kartan för fienden utifrån skott (AR, FK, MS, ED)
    public void colorChangesEnemy(String input){
        int valueX = Character.getNumericValue(input.charAt(0));
        int valueY =Character.getNumericValue(input.charAt(1));
        if (arrayEnemy[valueX][valueY].equals("h")||arrayEnemy[valueX][valueY].equals("s")) {
            FXarrayEnemy[valueX][valueY].setFill(Color.valueOf("6A994E"));
        }
        else {
            FXarrayEnemy[valueX][valueY].setFill(Color.valueOf("BC4749"));
        }
    }

    //Metod: Ändra färgen på sin egna FX karta utfrån skott (ED, FK, MS, AR)
    public void colorChangesYour(String input){
        int valueX = Character.getNumericValue(input.charAt(7));
        int valueY = covertYCharToYint((input.charAt(8)));
        if (arrayYours[valueX][valueY].equals("h")) {
            FXarrayYours[valueX][valueY].setFill(Color.valueOf("#6A994E"));
        }
        else {
            FXarrayYours[valueX][valueY].setFill(Color.valueOf("E8DAB2"));
        }
    }

    //Metod: Ändra startfärgerna på din egna FX karta (FK, ED, MS, AR)
    public void clientYourMapsColor(){
        for (int i = 0; i < XRowValue; i++){
            for (int j = 0; j < YRowValue; j++){
                if (arrayYours[i][j].equals("s")) {
                    FXarrayYours[i][j].setFill(Color.valueOf("6B6B5B"));
                }
                else {
                    FXarrayYours[i][j].setFill(Color.valueOf("023E8A"));
                }
            }

        }
    }

    //Metod: Omvandlar char till int (FK, ED, AR, MS)
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
}
