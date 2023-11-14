package FrontEnd;

import BackEnd.BackBord;
import BackEnd.BackEndMap;
import BackEnd.SystemBord;
import FrontEnd.GameBoard;
import FrontEnd.GameCell;
import javafx.scene.layout.Pane;
import FrontEnd.Fire;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GamePane extends Pane implements SystemBord {
    private String name;
    private int rows;
    private int columns;
    private GameCell[][] cells;// testar med en array för cellerna istället
    private BackEndMap backEndMap;

    public GamePane(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        //this.backEndMap = backEndMap;
        setPrefSize(columns * GameBoard.CELL_SIZE, rows * GameBoard.CELL_SIZE);
    }

    public void createGameCells(int rows, int columns,int f) { //Hämta input från
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

                double cellWidth = GameBoard.CELL_SIZE;
                double cellHeight = GameBoard.CELL_SIZE;
                cell.setTranslateX(finalX * cellWidth);
                cell.setTranslateY(finalY * cellHeight);
                getChildren().add(cell);


            }
        }
    }
    public void colorChanges(int valueX, int valueY){
        if (array[valueX][valueY].equals("i")){
            FXarrayServer[valueX][valueY].setFill(Color.GREEN);
        } else if (array[valueX][valueY].equals("s")) {
            FXarrayServer[valueX][valueY].setFill(Color.BLUE);
        }else if (array[valueX][valueY].equals("h")) {
            FXarrayServer[valueX][valueY].setFill(Color.DARKRED);
        }
        else {
            FXarrayServer[valueX][valueY].setFill(Color.OLIVEDRAB);
        }
    }

    }
