
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameBoard extends Application {

    private static final int GRID_SIZE_IN_CELLS = 5;
    private static final int CELL_SIZE = 75;
    private static final double SPACING = 50;
    private static final String SPELARE1 = "Spelare 1";
    private static final String SPELARE2 = "Spelare 2";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();

        Scene scene = new Scene(root, GRID_SIZE_IN_CELLS * CELL_SIZE, 2 * GRID_SIZE_IN_CELLS * CELL_SIZE);

        Label player1Label = new Label(SPELARE1);
        player1Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player1Label.setTextFill(Color.BLACK);

        Label player2Label = new Label(SPELARE2);
        player2Label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        player2Label.setTextFill(Color.BLACK);

        // Skapa numrering på vänster sida
        for (int i = 1; i <= GRID_SIZE_IN_CELLS; i++) {
            Label numLabel1 = new Label(String.valueOf(i));
            Label numLabel2 = new Label(String.valueOf(i));
            numLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            numLabel1.setTextFill(Color.BLACK);
            numLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            numLabel2.setTextFill(Color.BLACK);
            root.add(numLabel1, 0, i);
            root.add(numLabel2, GRID_SIZE_IN_CELLS + 1, i);
        }

        // Skapa bokstavsnamn ovanför
        for (char c = 'A'; c < 'A' + GRID_SIZE_IN_CELLS; c++) {
            Label letterLabel1 = new Label(String.valueOf(c));
            Label letterLabel2 = new Label(String.valueOf(c));
            letterLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            letterLabel1.setTextFill(Color.BLACK);
            letterLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            letterLabel2.setTextFill(Color.BLACK);
            root.add(letterLabel1, c - 'A' + 1, 0);
            root.add(letterLabel2, c - 'A' + 1, GRID_SIZE_IN_CELLS + 1);
        }

        GamePane gamePane1 = new GamePane();
        GamePane gamePane2 = new GamePane();

        // Justera avståndet mellan cellerna
        root.setHgap(10); // Horisontellt avstånd
        root.setVgap(10); // Vertikalt avstånd

        root.add(player1Label, 0, 0, 1, 1);
        root.add(gamePane1, 1, 1);
        root.add(player2Label, GRID_SIZE_IN_CELLS + 1, 0, 1, 1);
        root.add(gamePane2, GRID_SIZE_IN_CELLS + 2, 1);

        stage.setScene(scene);
        stage.show();
    }

    private static class GamePane extends Pane {
        GamePane() {
            setPrefSize(GRID_SIZE_IN_CELLS * CELL_SIZE, GRID_SIZE_IN_CELLS * CELL_SIZE);
            for (int y = 0; y < GRID_SIZE_IN_CELLS; y++) {
                for (int x = 0; x < GRID_SIZE_IN_CELLS; x++) {
                    Cell cell = new Cell(x, y);
                    cell.setOnMouseClicked(e -> {
                        cell.hit();
                        System.out.println("klicka på mig");
                    });
                    getChildren().add(cell);
                }
            }
        }
    }

    private static class Cell extends StackPane {
        private boolean isHitted = false;
        private Rectangle bg;

        Cell(int x, int y) {
            setTranslateY(x * CELL_SIZE);
            setTranslateX(y * CELL_SIZE);

            bg = new Rectangle(CELL_SIZE, CELL_SIZE, Color.GREY);
            bg.setStroke(Color.WHITE);
            getChildren().add(bg);
        }

        void hit() {
            isHitted = !isHitted;
            bg.setFill(isHitted ? Color.DARKGRAY : Color.RED);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
