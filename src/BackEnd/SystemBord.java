package BackEnd;

import java.util.ArrayList;
import java.util.List;

public interface SystemBord {
    int XRowValue = 10;
    int YRowValue = 10;
    //2D array for 2d kartan (AR)
    String[][] array = new String[XRowValue][YRowValue];

    //liv för båtnarna (AR)
    List<Integer> lifeOnBoat = new ArrayList<>();


}
