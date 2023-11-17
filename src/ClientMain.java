import BackEnd.BackEndMap;
import BackEnd.SystemBoard;
import FrontEnd.GameBoardLayout;
import ServerAndClient.Client;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application implements SystemBoard {

    private Client client = new Client();
    private GameBoardLayout gameBoard;
    private ClientThread clinetTread;

    public static void main (String[] args) throws IOException {
        BackEndMap backEndMap = new BackEndMap();
        backEndMap.createEndMap(XRowValue,YRowValue);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        client.connect();
        gameBoard = new GameBoardLayout();
        clinetTread = new ClientThread(client.getWriter(),client.getReader(), gameBoard, primaryStage);
        gameBoard.setClientThread(clinetTread);
        gameBoard.name = "client";
        gameBoard.start(primaryStage);



    }
}
