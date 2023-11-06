package FrontEnd;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameCell extends StackPane {
    private boolean isHit = false;
    private final Rectangle background;

    public GameCell() {
        background = new Rectangle(GameBoard.CELL_SIZE, GameBoard.CELL_SIZE, Color.GREY);
        background.setStroke(Color.BLACK);
        getChildren().add(background);
    }

    public void hit() {
        isHit = !isHit;
        background.setFill(isHit ? Color.GREEN : Color.RED);
    }

    public String getIndex(int x, int y) {
        char column = (char) ('A' + x);
        return String.valueOf(column) + (y + 1);
    }
}
