import BackEnd.BackEndMap;
import BackEnd.SystemBord;
import FrontEnd.GameBoard;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application implements SystemBord {

    Client client = new Client();
    public static void main (String[] args) throws IOException {
        BackEndMap backEndMap = new BackEndMap();
        backEndMap.createEndMap(XRowValue,YRowValue);




        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameBoard gameBoard = new GameBoard();


        gameBoard.start(primaryStage);
        client.connect();


    }
}
