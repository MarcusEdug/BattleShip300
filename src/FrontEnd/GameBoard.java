package FrontEnd;

import BackEnd.BackEndMap;
import BackEnd.SystemBord;
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

public class GameBoard extends Application implements SystemBord {
    public static final int CELL_SIZE = SystemBord.CELL_SIZE;
    public static final int X_ROW_VALUE = XRowValue;
    public static final int Y_ROW_VALUE = YRowValue;
    private static final String SPELARE1 = "Spelare 1";
    private static final String SPELARE2 = "Spelare 2";
    private BackEndMap backEndMap2;

    @Override
    public void start(Stage stage) {
        this.backEndMap2 = new BackEndMap();
        this.backEndMap2.bout51(); //tänk på att vi behöver eventuellt 2 st backendmaps.
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, X_ROW_VALUE * CELL_SIZE, Y_ROW_VALUE * CELL_SIZE);
        setupWindow(stage);
        setupPlayerLabels(gridPane);
        setupGamePanes(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    //Fönstrets inställningar
    private void setupWindow(Stage stage) {
        double windowWidth = 1300;
        double windowHeight = 550;
        stage.setMinWidth(1100);
        stage.setMaxWidth(2000);
        stage.setWidth(windowWidth);
        stage.setMinHeight(550);
        stage.setMaxHeight(1000);
        stage.setHeight(windowHeight);
    }

    private void setupPlayerLabels(GridPane gridPane) {
        Label player1Label = new Label(SPELARE1);
        player1Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player1Label.setTextFill(Color.BLACK);

        Label player2Label = new Label(SPELARE2);
        player2Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player2Label.setTextFill(Color.BLACK);

        gridPane.add(player1Label, 0, 0, 1, 1);
        gridPane.add(player2Label, X_ROW_VALUE + 1, 0, 1, 1);
    }

    private void setupGamePanes(GridPane gridPane) {
        GamePane gamePane1 = new GamePane("Spelplan 1", Y_ROW_VALUE, X_ROW_VALUE,this.backEndMap2);
        GamePane gamePane2 = new GamePane("Spelplan 2", Y_ROW_VALUE, X_ROW_VALUE, this.backEndMap2); //Behöver en till backendmap.
        HBox letterHBox1 = createLetterHBox();
        HBox letterHBox2 = createLetterHBox();
        VBox numVBox1 = createNumberVBox();
        VBox numVBox2 = createNumberVBox();

        gridPane.add(letterHBox1, 1, 0);
        gridPane.add(numVBox1, 0, 1);
        gridPane.add(gamePane1, 1, 1);
        gridPane.add(letterHBox2, X_ROW_VALUE + 2, 0);
        gridPane.add(numVBox2, Y_ROW_VALUE + 1, 1);
        gridPane.add(gamePane2, X_ROW_VALUE + 2, 1);
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

    public static void main(String[] args) {
        launch(args);
    }
}
