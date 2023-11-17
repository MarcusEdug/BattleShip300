package FrontEnd;

import BackEnd.SystemBoard;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellLayout extends Pane implements SystemBoard {
    private String name;
    private int rows;
    private int columns;


    public CellLayout(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        setPrefSize(columns * GameBoardLayout.CELL_SIZE, rows * GameBoardLayout.CELL_SIZE);
    }

    public void createGameCells(int rows, int columns,int f) {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                if (f == 2) {
                    FXarrayServer[y][x] = cell;
                } else FXarrayClient[y][x] = cell;

                if (array[y][x].equals("s")) {
                    FXarrayClient[y][x].setFill(Color.GREY);
                } else {
                    FXarrayClient[y][x].setFill(Color.NAVY);

                }

                cell.setFill(Color.NAVY);
                cell.setStroke(Color.BLACK);
                int finalX = x;
                int finalY = y;

                double cellWidth = GameBoardLayout.CELL_SIZE;
                double cellHeight = GameBoardLayout.CELL_SIZE;
                cell.setTranslateX(finalX * cellWidth);
                cell.setTranslateY(finalY * cellHeight);
                getChildren().add(cell);


                }
            }
        }
    }
