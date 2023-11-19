package FrontEnd;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartEndScreens {

    private ClientThread clientThread;
    private ServerThread serverThread;
    StartEndScreens(ClientThread clientThread , ServerThread serverThread){
        this.clientThread = clientThread;
        this.serverThread = serverThread;
    }

    //Metod: Upprättar en start fönster (AR, ED, MS, FK)
    public Scene display(String name, Scene scene, Stage stage){
        Label label = new Label();
        label.setFont(Font.font("Arial", FontWeight.BOLD,80));
        label.setText("Hej! Välj en delay");
        ChoiceBox <Integer> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll(0,1,2,3,4,5);
        choiceBox.setValue(3);
        Button closeButton = new Button(" Starta! ");

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

    //Metod: Upprättar en end fönster (ED, AR, FK, MS)
    public static void endplay (boolean winOrLose, Stage stage){
        Label label = new Label();
        label.setFont(Font.font("Arial", FontWeight.BOLD,100));
        if (winOrLose) {
            label.setText("Du vann!");
        }
        else {
            label.setText("FÖRLÅT!\nDu har förlorat!\n :(");
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

