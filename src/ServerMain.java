import BackEnd.BackEndMap;
import BackEnd.SystemBord;
import FrontEnd.GameBoard;
import ServerAndClient.Server;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerMain extends Application implements SystemBord {
    Server server = new Server();

    public static void main(String[]args) throws IOException {
        BackEndMap backEndMap = new BackEndMap();
        backEndMap.createEndMap(XRowValue,YRowValue);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        server.connect();
        GameBoard gameBoard = new GameBoard(server.getReader(),server.getWriter());
        gameBoard.name = "server";
        gameBoard.start(primaryStage);


    }


}
