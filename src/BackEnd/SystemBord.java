package BackEnd;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public interface SystemBord {
    int XRowValue = 9;
    int YRowValue = 9;
    int CELL_SIZE = 50;
    //2D array for 2d kartan (AR)
    String[][] array = new String[XRowValue][YRowValue];

    Rectangle[][] FXarray = new Rectangle[XRowValue][YRowValue];

    //liv för båtnarna (AR)
    List<Integer> lifeOnBoat = new ArrayList<>();


}
