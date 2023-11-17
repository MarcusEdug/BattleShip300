package FrontEnd;

import BackEnd.SystemBoard;
import ServerAndClient.ClientThread;
import ServerAndClient.ServerThread;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class GameBoardLayout extends Application implements SystemBoard {
    private static final int X_ROW_VALUE = XRowValue;
    private static final int Y_ROW_VALUE = YRowValue;
    private static final String SPELARE1 = "Min spelplan";
    private static final String SPELARE2 = "Fiendens spelplan";
    public String name;
    private Scene scene1;
    private Scene scene2;
    private Text shipText = new Text("");
    private ClientThread clientThread;
    private ServerThread serverThread;

    public GameBoardLayout(){}
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        StartEndScreens StartEndScreens = new StartEndScreens(clientThread, serverThread);
        scene1 = new Scene(gridPane, X_ROW_VALUE * CELL_SIZE, Y_ROW_VALUE * CELL_SIZE);
        scene2 = StartEndScreens.display(name,scene1, stage);
        setupWindow(stage);
        //setupPlayerLabels(gridPane);
        setupGamePanes(gridPane);
        stage.setScene(scene2);
        stage.show();

    }


    //Metod: Ändra storlek på fönstret utefrån sin egen dator skärm (FK, AR, MS, ED)
    public void setupWindow(Stage stage) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bonus = screen.getVisualBounds();

        double windowWidth = bonus.getWidth()*0.7;
        double windowHeight = bonus.getHeight()*0.57;
        stage.setWidth(windowWidth);
        stage.setHeight(windowHeight);


    }

    //Upprättar vad som finns i våran FX karta (ED, MS, AR, FK)
    public void setupGamePanes(GridPane gridPane) {
        Text player1Label = new Text(SPELARE1);
        player1Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Text player2Label = new Text (SPELARE2);
        player2Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        shipText.setFont(Font.font("Arial", FontWeight.BOLD, 14));


        CellLayout gamePane1 = new CellLayout("Spelplan 1", Y_ROW_VALUE, X_ROW_VALUE);
        gamePane1.createGameCells(XRowValue,YRowValue, 1);
        CellLayout gamePane2 = new CellLayout("Spelplan 2", Y_ROW_VALUE, X_ROW_VALUE); //Behöver en till backendmap.
        gamePane2.createGameCells(XRowValue,YRowValue,2);
        HBox letterHBox1 = createLetterHBox();
        HBox letterHBox2 = createLetterHBox();
        VBox numVBox1 = createNumberVBox();
        VBox numVBox2 = createNumberVBox();
        //gridPane.setGridLinesVisible(true);

        Text extraColum = new Text("                                               ");
        gridPane.add(player1Label, 2, 0, 1, 1);
        gridPane.add(letterHBox1, 2, 1);
        gridPane.add(numVBox1, 1, 2);
        gridPane.add(gamePane1, 2, 2);
        gridPane.add(extraColum,3,1);

        gridPane.add(player2Label,  X_ROW_VALUE + 6, 0);
        gridPane.add(letterHBox2, X_ROW_VALUE + 6, 1);
        gridPane.add(numVBox2, Y_ROW_VALUE + 5, 2);
        gridPane.add(gamePane2, X_ROW_VALUE + 6, 2);
        gridPane.add(shipText, 3,2);


    }

    //Metod: Skapar en HBox med Y koordinater (FK)
    private HBox createLetterHBox() {
        HBox letterHBox = new HBox();
        letterHBox.setPrefSize(X_ROW_VALUE * CELL_SIZE, CELL_SIZE*0.5);
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

    //Metod: Skapar en VBox med X koordinater (FK)
    private VBox createNumberVBox() {
        VBox numVBox = new VBox();
        numVBox.setPrefSize(CELL_SIZE*0.5, Y_ROW_VALUE * CELL_SIZE);
        for (int i = 0; i < Y_ROW_VALUE; i++) {
            Label numLabel = new Label(String.valueOf(i));
            numLabel.setFont(Font.font("Arial", FontWeight.BOLD, CELL_SIZE * 0.5));
            numLabel.setTextFill(Color.BLACK);
            numLabel.setPrefHeight(CELL_SIZE);
            numLabel.setAlignment(Pos.BASELINE_RIGHT);
            numVBox.getChildren().add(numLabel);
        }
        return numVBox;
    }

    //Metod: Gör så att de kommer upp en text på FX kartan att ett skepp
    public void changeText(String temp){
        if(temp.equals("s")){
            shipText.setText("Ett helt sjäp har träffas");
        }
        else {
            shipText.setText("");
        }
    }

    public void setClientThread(ClientThread clientThread) {
        this.clientThread = clientThread;
    }

    public void setServerThread(ServerThread serverThread) {
        this.serverThread = serverThread;
    }

    public static void main(String[] args) {
        launch(args);
    }



}
