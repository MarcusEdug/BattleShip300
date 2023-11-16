package FrontEnd;

import BackEnd.SystemBord;
import javafx.scene.paint.Color;

public class ChangeColor implements SystemBord {
    /*

    Metoden tar in 2 int värden
    Sedan så kollar vad de står på string element i 2D arrayen "array[][]"
    och beroende på vad som står så ändra den färg på FX borden i genom att utnjuta 2D arrayen "array3d [][]"


     */

    public void colorChangesEnemy(String input){
        int valueX = Character.getNumericValue(input.charAt(0));
        int valueY =Character.getNumericValue(input.charAt(1));
        if (arrayEnemy[valueX][valueY].equals("h")||arrayEnemy[valueX][valueY].equals("s")) {
            FXarrayServer[valueX][valueY].setFill(Color.GREEN);
        }
        else {
            FXarrayServer[valueX][valueY].setFill(Color.ORANGERED);
        }
        //System.out.println(arrayEnemy[valueX][valueY]);
    }
    public void colorChangesYour(String input){
        int valueX = Character.getNumericValue(input.charAt(7));
        int valueY =Character.getNumericValue(input.charAt(8));
        if (array[valueX][valueY].equals("h")) {
            FXarrayClient[valueX][valueY].setFill(Color.GREEN);
        }
        else {
            FXarrayClient[valueX][valueY].setFill(Color.LIGHTGRAY);
        }
    }

    public void clientColor(){
        for (int i = 0; i < XRowValue; i++){
            for (int j = 0; j < YRowValue; j++){
                if (array[i][j].equals("s")) {
                    FXarrayClient[i][j].setFill(Color.GREY);
                }
                else {
                    FXarrayClient[i][j].setFill(Color.NAVY);
                }
            }

        }
    }
}
