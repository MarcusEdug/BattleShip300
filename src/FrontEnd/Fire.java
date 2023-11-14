package FrontEnd;

import BackEnd.SystemBord;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fire implements SystemBord {
    String YRow;
    int indexX;
    int indexY;
    int randomNumber;
    ChangeColor changeColor = new ChangeColor();
    Random random = new Random();
    String shotFire;
    int count = 0;
    //en lista på alla skot som har skjutis (AR)
    List<String> listOfShot = new ArrayList<>();
    public String shotStatus = "i";
    public String coordinat;

    // Skapar en random Sträng av två int värden som har en ett random värde. (AR , FK)
    public String fireOutput(int x, int y) {
        boolean isFiring = true;
        while (isFiring) {
            indexX = random.nextInt(x);
            indexY= random.nextInt(y);

            convertIntToString(indexY);

            shotFire = String.join("",shotStatus, " shot ", String.valueOf(indexX), String.valueOf(indexY));
            if (!listOfShot.contains(shotFire)) {
                listOfShot.add(shotFire);
                count++;
                isFiring = false;
            }
        }
        return shotFire;
    }

    //Tar emot ett sträng värde och bryter upp de till två int värden som sätts in i array[][] som blir kordinater.
    public void fireInput(String shotInput) {
        int valueX = Character.getNumericValue(shotInput.charAt(7));
        int valueY =Character.getNumericValue(shotInput.charAt(8));
        if (array[valueX][valueY].equals("s")) {
            System.out.println("Jag har blivt Hit!");
            array[valueX][valueY] = "h";
            //lifeOnBoat.remove(0);
        }
        else {
            System.out.println("Jag har blivt Miss!");
            array[valueX][valueY] = "m";
        }
        shotStatus = array[valueX][valueY];
    }
    public void changeArray(String shotCoordinat, String temp){
        int valueX = Character.getNumericValue(shotCoordinat.charAt(0));
        int valueY = Character.getNumericValue(shotCoordinat.charAt(1));
        if (temp.equals("h")) {
            arrayEnemy[valueX][valueY] = "h";
            //FXarrayServer[valueX][valueY].setFill(Color.GREEN);
        }
        else {
            arrayEnemy[valueX][valueY] = "m";
            //FXarrayServer[valueX][valueY].setFill(Color.OLIVEDRAB);
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
    public String breakOut (String breakOut){
        String temp;
        int valueX = Character.getNumericValue(breakOut.charAt(7));
        int valueY =Character.getNumericValue(breakOut.charAt(8));
        temp = String.join("", String.valueOf(valueX), String.valueOf(valueY));

        return temp;
    }
}
