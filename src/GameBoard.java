import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameBoard extends Application {
    private static final int GRID_SIZE_IN_CELLS = 10;
    private static final int CELL_SIZE = 40;
    private static final String SPELARE1 = "Spelare 1";
    private static final String SPELARE2 = "Spelare 2";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, (GRID_SIZE_IN_CELLS + 2) * CELL_SIZE, (GRID_SIZE_IN_CELLS + 1) * CELL_SIZE);

        Label player1Label = new Label(SPELARE1);
        player1Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player1Label.setTextFill(Color.BLACK);

        Label player2Label = new Label(SPELARE2);
        player2Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player2Label.setTextFill(Color.BLACK);

        VBox numVBox1 = createNumberVBox();
        VBox numVBox2 = createNumberVBox();
        HBox letterHBox1 = createLetterHBox();
        HBox letterHBox2 = createLetterHBox();
        GamePane gamePane1 = new GamePane("Spelplan 1");
        GamePane gamePane2 = new GamePane("Spelplan 2");

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(player1Label, 0, 0, 1, 1);
        gridPane.add(letterHBox1, 1, 0);
        gridPane.add(numVBox1, 0, 1);
        gridPane.add(gamePane1, 1, 1);
        gridPane.add(player2Label, GRID_SIZE_IN_CELLS + 1, 0, 1, 1);
        gridPane.add(letterHBox2, GRID_SIZE_IN_CELLS + 2, 0);
        gridPane.add(numVBox2, GRID_SIZE_IN_CELLS + 1, 1);
        gridPane.add(gamePane2, GRID_SIZE_IN_CELLS + 2, 1);

        stage.setScene(scene);
        stage.show();
    }

    private VBox createNumberVBox() {
        VBox numVBox = new VBox();
        numVBox.setPrefSize(CELL_SIZE, GRID_SIZE_IN_CELLS * CELL_SIZE);
        for (int i = 1; i <= GRID_SIZE_IN_CELLS; i++) {
            Label numLabel = new Label(String.valueOf(i));
            numLabel.setFont(Font.font("Arial", FontWeight.BOLD, CELL_SIZE * 0.5)); // Justera storleken
            numLabel.setTextFill(Color.BLACK);
            numLabel.setPrefHeight(CELL_SIZE);
            numLabel.setAlignment(Pos.BASELINE_RIGHT);
            numVBox.getChildren().add(numLabel);
        }
        return numVBox;
    }

    private HBox createLetterHBox() {
        HBox letterHBox = new HBox();
        letterHBox.setPrefSize(GRID_SIZE_IN_CELLS * CELL_SIZE, CELL_SIZE);
        for (int i = 1; i <= GRID_SIZE_IN_CELLS; i++) {
            Label letterLabel = new Label(String.valueOf((char)('A' + i - 1)));
            letterLabel.setFont(Font.font("Arial", FontWeight.BOLD, CELL_SIZE * 0.5));
            letterLabel.setTextFill(Color.BLACK);
            letterLabel.setPrefWidth(CELL_SIZE);
            letterLabel.setAlignment(Pos.CENTER);
            letterHBox.getChildren().add(letterLabel);
        }
        return letterHBox;
    }

    private static class GamePane extends Pane {
        private String name;
        GamePane(String name) {
            this.name = name;
            setPrefSize(GRID_SIZE_IN_CELLS * CELL_SIZE, GRID_SIZE_IN_CELLS * CELL_SIZE);
            for (int y = 0; y < GRID_SIZE_IN_CELLS; y++) {
                for (int x = 0; x < GRID_SIZE_IN_CELLS; x++) {
                    Cell cell = new Cell(x, y);
                    cell.setOnMouseClicked(e -> {
                        cell.hit();
                        System.out.println("Du klickade på: " + name + "-" + cell.getIndex());
                    });
                    getChildren().add(cell);
                }
            }
        }
    }

    private static class Cell extends StackPane {
        private boolean isHitted = false;
        private Rectangle bg;
        private int x;
        private int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
            setTranslateX(x * CELL_SIZE);
            setTranslateY(y * CELL_SIZE);

            bg = new Rectangle(CELL_SIZE, CELL_SIZE, Color.DARKGRAY);
            bg.setStroke(Color.BLACK);
            getChildren().add(bg);
        }

        void hit() {
            isHitted = !isHitted;
            bg.setFill(isHitted ? Color.GREEN : Color.RED);
        }

        String getIndex() {
            char column = (char) ('A' + y);
            return String.valueOf(column) + (x + 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
