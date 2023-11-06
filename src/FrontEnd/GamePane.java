package FrontEnd;

import BackEnd.BackBord;
import BackEnd.BackEndMap;
import FrontEnd.GameBoard;
import FrontEnd.GameCell;
import javafx.scene.layout.Pane;
import FrontEnd.Fire;

import java.util.ArrayList;

public class GamePane extends Pane {
    private String name;
    private int rows;
    private int columns;
    private GameCell[][] cells;// testar med en array för cellerna istället
    private BackEndMap backEndMap;

    public GamePane(String name, int rows, int columns, BackEndMap backEndMap) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        this.backEndMap = backEndMap;
        setPrefSize(columns * GameBoard.CELL_SIZE, rows * GameBoard.CELL_SIZE);
        /*cells = new GameCell[rows][columns]; // testar med en array för cellerna istället
        createGameCells(rows, columns);*/
    }
//Hej
    private void createGameCells(int rows, int columns) { //Hämta input från
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                GameCell cell = new GameCell();
                int finalX = x;
                int finalY = y;

                //Anonym funktion = lambda
                cell.setOnMouseClicked(e -> {
                    //anropa backendmap
                    System.out.println(this.backEndMap.checkValue(finalX, finalY));


                });
                double cellWidth = GameBoard.CELL_SIZE;
                double cellHeight = GameBoard.CELL_SIZE;
                cell.setTranslateX(finalX * cellWidth);
                cell.setTranslateY(finalY * cellHeight);
                getChildren().add(cell);
            }
        }
    }

  /* private void createGameCells(int rows, int columns) {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                GameCell cell = new GameCell();
                double cellWidth = GameBoard.CELL_SIZE;
                double cellHeight = GameBoard.CELL_SIZE;
                cell.setTranslateX(x * cellWidth);
                cell.setTranslateY(y * cellHeight);

                cells[y][x] = cell;
                getChildren().add(cell);
            }
        }
    }

    public void updateCellStatus(int x, int y, String status) {
        if (x >= 0 && x < columns && y >= 0 && y < rows) {
            cells[y][x].updateStatus(status);
        }
    }
    */
}