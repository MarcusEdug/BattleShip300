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
    Server server = new Server();
    GameBoardLayout gameBoard;

    public static void main(String[]args) throws IOException {
        BackEndMap backEndMap = new BackEndMap();
        backEndMap.createEndMap(XRowValue,YRowValue);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        server.connect();
        //ServerThread serverThread = new ServerThread(server.getWriter(),server.getReader(),primaryStage,gameBoard );
        gameBoard = new GameBoardLayout(server.getReader(),server.getWriter());
        gameBoard.name = "server";
        gameBoard.start(primaryStage);


    }


}
