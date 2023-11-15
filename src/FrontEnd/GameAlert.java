package FrontEnd;
import java.io.*;
import BackEnd.SystemBord;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

public class GameAlert implements SystemBord {



    public static Scene display (Stage stage,Scene scene){
        /*Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Delay windows!");
        window.setMinWidth(250);

         */

        Label label = new Label();
        label.setText("hej");
        ChoiceBox <Integer> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll(1,2,3,4,5);
        choiceBox.setValue(3);
        Button closeButton = new Button("Set");

        ServerThread serverThread = new ServerThread();
        Thread serverMainTread = new Thread(serverThread);

        ClientThread clinetTread = new ClientThread();
        Thread clientMainThread = new Thread(clinetTread);

        closeButton.setOnAction(e-> {
            delayTime.add(choiceBox.getValue());
            System.out.println(delayTime.get(0));
            stage.setScene(scene);


            clientMainThread.start();
            serverMainTread.start();
            //window.close();
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,choiceBox,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout);
        /*
        window.setScene(scene);
        window.showAndWait();*/
        return scene1;
    }

}

