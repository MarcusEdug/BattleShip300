
import BackEnd.BackBord;
import FrontEnd.Fire;
import FrontEnd.GameBoard;
import FrontEnd.GamePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application{
    GameBoard gameBoard = new GameBoard();
    MyThread myThread = new MyThread();
    Thread backendThread = new Thread(myThread);

    MyThread2 myThread2 = new MyThread2();
    Thread FXThread = new Thread(myThread2);

    public static void main(String[] args) throws InterruptedException {

        /*//System.out.println("Hello world!");
        //Fire fire = new Fire();
        MyThread2 runnable2 = new MyThread2();
        Thread thread2 = new Thread(runnable2);
        thread1.setPriority(10); //thread1 kommer alltid att köras först (ex client)
        thread1.start();
        //thread1.join(2000); //Skapar en delay för thread2. Kommer att avslutas 2 sekunder efter thread1 är klar.
        thread2.start();*/
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = primaryStage;
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, gameBoard.X_ROW_VALUE * gameBoard.CELL_SIZE, gameBoard.Y_ROW_VALUE * gameBoard.CELL_SIZE);
        gameBoard.setupWindow(stage);
        gameBoard.setupPlayerLabels(gridPane);
        gameBoard.setupGamePanes(gridPane);
        stage.setScene(scene);
        stage.show();

        backendThread.start();
    }
}

