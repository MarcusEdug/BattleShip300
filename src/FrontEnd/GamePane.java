package FrontEnd;

import FrontEnd.GameBoard;
import FrontEnd.GameCell;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {
    private String name;
    private int rows;
    private int columns;

    public GamePane(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        setPrefSize(columns * GameBoard.CELL_SIZE, rows * GameBoard.CELL_SIZE);
        createGameCells(rows, columns);
    }

    private void createGameCells(int rows, int columns) {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                GameCell cell = new GameCell();
                int finalX = x;
                int finalY = y;
                cell.setOnMouseClicked(e -> {
                    cell.hit();
                    System.out.println("Du klickade på: " + name + "-" + cell.getIndex(finalX, finalY));
                });
                double cellWidth = GameBoard.CELL_SIZE;
                double cellHeight = GameBoard.CELL_SIZE;
                cell.setTranslateX(finalX * cellWidth);
                cell.setTranslateY(finalY * cellHeight);
                getChildren().add(cell);
            }
        }
    }
}
