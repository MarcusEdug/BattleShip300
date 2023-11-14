import FrontEnd.GameBoard;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerMain extends Application {

    public static void main(String[]args) throws IOException {
        Server server = new Server();
        server.connect();


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameBoard gameBoard = new GameBoard();

        gameBoard.start(primaryStage);
    }
}
