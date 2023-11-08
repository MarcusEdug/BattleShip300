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
    int indexX;
    int indexY;
    int randomNumber;
    Random random = new Random();
    String shotFire;
    int count = 0;
    //en lista på alla skot som har skjutis (AR)
    List<String> listOfShot = new ArrayList<>();

    // Skapar en random Sträng av två int värden som har en ett random värde. (AR , FK)
    public String fireOutput(int x, int y) {
        boolean isFiring = true;
        while (isFiring) {
            indexX = randomNumber = random.nextInt(x);
            indexY = randomNumber = random.nextInt(y);
            shotFire = String.join("", String.valueOf(indexX), String.valueOf(indexY));
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
        int valueX = Character.getNumericValue(shotInput.charAt(0));
        int valueY =Character.getNumericValue(shotInput.charAt(1));
        if (array[valueX][valueY].equals("s")) {
            System.out.println("Hit!");
            array[valueX][valueY] = "h";
            lifeOnBoat.remove(0);
        }
        else {
            System.out.println("Miss!");
            array[valueX][valueY] = "m";
        }
    }
}
