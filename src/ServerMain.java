import BackEnd.BackEndMap;
import BackEnd.SystemBoard;
import FrontEnd.GameBoardLayout;
import ServerAndClient.ClientThread;
import ServerAndClient.Server;
import ServerAndClient.ServerThread;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerMain extends Application implements SystemBoard {
    private Server server = new Server();
    private GameBoardLayout gameBoardLayout;

    public static void main(String[]args) throws IOException {
        BackEndMap backEndMap = new BackEndMap();
        backEndMap.createEndMap(XRowValue,YRowValue);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        server.connect();
        gameBoardLayout = new GameBoardLayout();
        ServerThread serverThread = new ServerThread(server.getWriter(),server.getReader(), gameBoardLayout, primaryStage);
        gameBoardLayout.setServerThread(serverThread);
        gameBoardLayout.name = "server";
        gameBoardLayout.start(primaryStage);


    }


}
