package FrontEnd;
import BackEnd.SystemBoard;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartEndScreens implements SystemBoard {

    private ClientThread clientThread;
    private ServerThread serverThread;
    StartEndScreens(ClientThread clientThread , ServerThread serverThread){
        this.clientThread = clientThread;
        this.serverThread = serverThread;
    }
    public Scene display(String name, Scene scene, Stage stage){
        Label label = new Label();
        label.setText("hej");
        ChoiceBox <Integer> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll(0,1,2,3,4,5);
        choiceBox.setValue(3);
        Button closeButton = new Button("Set");

        closeButton.setOnAction(e-> {
            int delay = choiceBox.getValue();
            stage.setScene(scene);
            stage.setTitle(name);

            Thread serverMainTread = new Thread(serverThread);
            Thread clientMainThread = new Thread(clientThread);

            if (name.equals("client")){
                clientThread.setDelay(delay);
                System.out.println(delay);

                clientMainThread.start();
            }
            else {
                serverThread.setDelay(delay);
                System.out.println(delay);

                serverMainTread.start();

            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,choiceBox,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout);
        return scene1;
    }


    public static void endplay (boolean winOrLose, Stage stage){
        Label label = new Label();
        if (winOrLose) {
            label.setText("You won");
        }
        else {
            label.setText("You lost");
        }
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        Platform.runLater(()->{
            Scene scene3  = new Scene(layout);
            stage.setScene(scene3);
        });
    }
}

