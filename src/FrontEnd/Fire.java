package FrontEnd;

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
import java.util.Random;

public class Fire {
    String idX;
    String idY;
    String idCell;
    int randomNumber;
    public String fireRandom (){
        Random random = new Random();

        idX = String.valueOf(randomNumber = random.nextInt(8));
        idY = String.valueOf(randomNumber = random.nextInt(8));
        idCell = String.join("",idX,idY);
        return idCell;
    }


}
