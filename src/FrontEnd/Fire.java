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
        //Skjutt metod. Justera om de är hit/miss eller om redan har skjut där
        public void fireRandom (int x, int y) {
        indexX = randomNumber = random.nextInt(x);
        indexY = randomNumber = random.nextInt(y);
            if (array[indexX][indexY].equals("s")) {
                System.out.println("Hit!");
                array[indexX][indexY] = "h";
                lifeOnBoat.remove(0);
            }
            else if (array[indexX][indexY].equals("h") || array[indexX][indexY].equals("m")){
                fireRandom(x,y);
            }
            else {
                System.out.println("Miss!");
                array[indexX][indexY] = "m";
            }
    }
}
