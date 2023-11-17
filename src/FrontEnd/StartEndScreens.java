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


    //public Stage stage;
    //Scene scene;
    //BufferedReader reader;
    //PrintWriter writer;
    ClientThread clientThread;
    ServerThread serverThread;
    StartEndScreens(ClientThread clientThread , ServerThread serverThread){
        this.clientThread = clientThread;
        this.serverThread = serverThread;
        //this.stage = stage;
        //this.scene = scene;
        //this.reader = reader;
        //this.writer = writer;
    }
    public Scene display(String name, Scene scene, Stage stage){
        /*Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Delay windows!");
        window.setMinWidth(250);

         */

        Label label = new Label();
        label.setText("hej");
        ChoiceBox <Integer> choiceBox = new ChoiceBox <>();
        choiceBox.getItems().addAll(0,1,2,3,4,5);
        choiceBox.setValue(3);
        Button closeButton = new Button("Set");

        closeButton.setOnAction(e-> {
            //delayTime.add(choiceBox.getValue());
            int delay = choiceBox.getValue();
            stage.setScene(scene);
            stage.setTitle(name);
            //ServerThread serverThread = new ServerThread(writer,reader,delay,stage);
            Thread serverMainTread = new Thread(serverThread);

            //ClientThread clinetTread = new ClientThread(writer,reader,delay,stage);
            Thread clientMainThread = new Thread(clientThread);

            if (name.equals("client")){
                //Client client = new Client(delay);
                clientThread.setDelay(delay);
                System.out.println(delay);
                //client.connect();

                clientMainThread.start();
            }
            else {
                //Server server = new Server(delay);
                serverThread.setDelay(delay);
                System.out.println(delay);
                //server.connect();

                serverMainTread.start();

            }
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

       // Scene scene3 = new Scene(layout);
        Platform.runLater(()->{
            Scene scene3  = new Scene(layout);
            stage.setScene(scene3);
        });
    }
}

