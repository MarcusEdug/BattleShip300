package FrontEnd;

import BackEnd.SystemBoard;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class GameBoardLayout extends Application implements SystemBoard {
    public static final int CELL_SIZE = SystemBoard.CELL_SIZE;
    public static final int X_ROW_VALUE = XRowValue;
    public static final int Y_ROW_VALUE = YRowValue;
    private static final String SPELARE1 = "Min spelplan";
    private static final String SPELARE2 = "Fiendens spelplan";
    public String name;
    private Scene scene1;
    private Scene scene2;
    public String shipDown = " hej";
    private BufferedReader reader;
    private PrintWriter writer;

    //ClientThread clientThread;
   // ServerThread serverThread;
    public GameBoardLayout(BufferedReader reader, PrintWriter writer){
        this.reader = reader;
        this.writer = writer;
    }


    /*public GameBoardLayout(ClientThread clientThread){
        this.clientThread = clientThread;

    }
    public GameBoardLayout(ServerThread serverThread){
        this.serverThread = serverThread;
    }

     */
    public GameBoardLayout(){}
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        ClientThread clinetTread = new ClientThread(writer,reader,stage);
        ServerThread serverThread = new ServerThread(writer,reader,stage);
        StartEndScreens StartEndScreens = new StartEndScreens(clinetTread, serverThread);
        scene1 = new Scene(gridPane, X_ROW_VALUE * CELL_SIZE, Y_ROW_VALUE * CELL_SIZE);
        scene2 = StartEndScreens.display(name,scene1, stage);
        setupWindow(stage);
        setupPlayerLabels(gridPane);
        setupGamePanes(gridPane);

        stage.setScene(scene2);
        stage.show();

    }


    //Fönstrets inställningar
    public void setupWindow(Stage stage) {
        double windowWidth = 1300;
        double windowHeight = 550;
        stage.setMinWidth(1100);
        stage.setMaxWidth(2000);
        stage.setWidth(windowWidth);
        stage.setMinHeight(550);
        stage.setMaxHeight(1000);
        stage.setHeight(windowHeight);
    }

    public void setupPlayerLabels(GridPane gridPane) {
        Label player1Label = new Label(SPELARE1);
        player1Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player1Label.setTextFill(Color.BLACK);

        Label player2Label = new Label(SPELARE2);
        player2Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player2Label.setTextFill(Color.BLACK);

        gridPane.add(player1Label, 0, 0, 1, 1);
        gridPane.add(player2Label, X_ROW_VALUE + 1, 0, 1, 1);
    }

    public void setupGamePanes(GridPane gridPane) {
        CellLayout gamePane1 = new CellLayout("Spelplan 1", Y_ROW_VALUE, X_ROW_VALUE);
        gamePane1.createGameCells(XRowValue,YRowValue, 1);
        CellLayout gamePane2 = new CellLayout("Spelplan 2", Y_ROW_VALUE, X_ROW_VALUE); //Behöver en till backendmap.
        gamePane2.createGameCells(XRowValue,YRowValue,2);
        HBox letterHBox1 = createLetterHBox();
        HBox letterHBox2 = createLetterHBox();
        VBox numVBox1 = createNumberVBox();
        VBox numVBox2 = createNumberVBox();
        Label label = new Label(shipDown);

        gridPane.add(letterHBox1, 1, 0);
        gridPane.add(numVBox1, 0, 1);
        gridPane.add(gamePane1, 1, 1);
        gridPane.add(letterHBox2, X_ROW_VALUE + 2, 0);
        gridPane.add(numVBox2, Y_ROW_VALUE + 1, 1);
        gridPane.add(gamePane2, X_ROW_VALUE + 2, 1);
        gridPane.add(label,13,1 );


    }

    private HBox createLetterHBox() {
        HBox letterHBox = new HBox();
        letterHBox.setPrefSize(X_ROW_VALUE * CELL_SIZE, CELL_SIZE);
        for (int i = 1; i <= X_ROW_VALUE; i++) {
            Label letterLabel = new Label(String.valueOf((char) ('A' + i - 1)));
            letterLabel.setFont(Font.font("Arial", FontWeight.BOLD, CELL_SIZE * 0.5));
            letterLabel.setTextFill(Color.BLACK);
            letterLabel.setPrefWidth(CELL_SIZE);
            letterLabel.setAlignment(Pos.CENTER);
            letterHBox.getChildren().add(letterLabel);
        }
        return letterHBox;
    }

    private VBox createNumberVBox() {
        VBox numVBox = new VBox();
        numVBox.setPrefSize(CELL_SIZE, Y_ROW_VALUE * CELL_SIZE);
        for (int i = 1; i <= Y_ROW_VALUE; i++) {
            Label numLabel = new Label(String.valueOf(i));
            numLabel.setFont(Font.font("Arial", FontWeight.BOLD, CELL_SIZE * 0.5));
            numLabel.setTextFill(Color.BLACK);
            numLabel.setPrefHeight(CELL_SIZE);
            numLabel.setAlignment(Pos.BASELINE_RIGHT);
            numVBox.getChildren().add(numLabel);
        }
        return numVBox;
    }

    public String getShipDown() {
        return shipDown;
    }

    public void setShipDown(String shipDown) {
        if (shipDown == null){
            this.shipDown = "..";
        }
        else {
            this.shipDown = shipDown;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }



}
