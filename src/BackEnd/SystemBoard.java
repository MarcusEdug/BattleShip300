package BackEnd;

import javafx.scene.shape.Rectangle;

public interface SystemBoard {

    /*
    Klass som använder sig av den här interface
    -BackEndControl
    -ChangeColor
    -ClientThread
    -ClientMain
    -ServerThread
    -ServerMain
    -CellLayout
    -GameBoardLayout

     */
    int XRowValue = 10;
    int YRowValue = 10;
    int CELL_SIZE = 50;
    String[][] arrayYours = new String[XRowValue][YRowValue];
    String[][] arrayEnemy = new String[XRowValue][YRowValue];
    Rectangle[][] FXarrayEnemy = new Rectangle[XRowValue][YRowValue];
    Rectangle[][] FXarrayYours = new Rectangle[XRowValue][YRowValue];

}
