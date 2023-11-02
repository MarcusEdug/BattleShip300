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
    List<String> shotList = new ArrayList<>();

    String shotId;
    int indexX;
    int indexY;
    int randomNumber;
    Random random = new Random();
        public void fireRandom (int x, int y) {
        indexX = randomNumber = random.nextInt(x);
        indexY = randomNumber = random.nextInt(y);
            if (array[indexX][indexY].equals("s")) {
                System.out.println("Hit!");
                array[indexX][indexY] = "h";
                System.out.println(lifeOnBoat.size());
                lifeOnBoat.remove(0);
                System.out.println(lifeOnBoat.size());
            }
            else {
                System.out.println("Miss!");
                array[indexX][indexY] = "m";
            }

    }

    public void shotsFired (int x, int y){
        String IdX = String.valueOf(x);
        String IdY = String.valueOf(y);
        shotId = String.join("",IdX,IdY);
        shotList.add(shotId);
    }


}
