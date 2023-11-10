import FrontEnd.GameBoard;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyThread2 extends Application implements Runnable{
    //Kan "extend" en annan klass om det behövs.
    Stage window;
    GameBoard gameBoard = new GameBoard();

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
    }
    @Override
    public void run() {
        try {
            gameBoard.start(window);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
