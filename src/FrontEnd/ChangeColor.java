package FrontEnd;

import BackEnd.SystemBord;
import javafx.scene.paint.Color;

public class ChangeColor implements SystemBord {
    /*

    Metoden tar in 2 int värden
    Sedan så kollar vad de står på string element i 2D arrayen "array[][]"
    och beroende på vad som står så ändra den färg på FX borden i genom att utnjuta 2D arrayen "array3d [][]"


     */
    public void colorChanges(int x, int y){
        if (array[x][y].equals("i")){
            FXarray[x][y].setFill(Color.GREEN);
        } else if (array[x][y].equals("s")) {
            FXarray[x][y].setFill(Color.BLUE);
        }else if (array[x][y].equals("h")) {
            FXarray[x][y].setFill(Color.YELLOW);
        }
        else {
            FXarray[x][y].setFill(Color.RED);
        }
    }
}
