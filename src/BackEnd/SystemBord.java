package BackEnd;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public interface SystemBord {
    int XRowValue = 10;
    int YRowValue = 10;
    int CELL_SIZE = 50;
    //2D array for 2d kartan (AR)
    String[][] array = new String[XRowValue][YRowValue];
    String[][] arrayEnemy = new String[XRowValue][YRowValue];

    Rectangle[][] FXarrayServer = new Rectangle[XRowValue][YRowValue];
    Rectangle[][] FXarrayClient = new Rectangle[XRowValue][YRowValue];

    //liv för båtnarna (AR)
    //List<Integer> lifeOnBoat = new ArrayList<>();
    List<Integer> delayTime = new ArrayList<>();


}
