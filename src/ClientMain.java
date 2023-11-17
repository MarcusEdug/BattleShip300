import BackEnd.Fire;
import BackEnd.SystemBoard;
import FrontEnd.GameBoardLayout;
import ServerAndClient.Client;
import ServerAndClient.ClientThread;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application implements SystemBoard {

    private Client client = new Client();
    private GameBoardLayout gameBoardLayout;
    private ClientThread clinetTread;

    public static void main (String[] args) throws IOException {
        Fire backEndMap = new Fire();
        backEndMap.createEndMap(XRowValue,YRowValue);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        client.connect();
        gameBoardLayout = new GameBoardLayout();
        clinetTread = new ClientThread(client.getWriter(),client.getReader(), gameBoardLayout, primaryStage);
        gameBoardLayout.setClientThread(clinetTread);
        gameBoardLayout.name = "client";
        gameBoardLayout.start(primaryStage);



    }
}
