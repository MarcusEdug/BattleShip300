import java.util.concurrent.TimeUnit;

public class TestBåtar {
    private final char[][] board = {
            {1, 0, 0, 0, 0}, //2 = liten båt
            {1, 0, 0, 1, 1}, //3 = mellanstor båt
            {1, 0, 0, 0, 0}, //4 = stor båt
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0}
    };

    public void fire(int row, int column) {
        try {
            if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) {
                System.out.println("Invalid position.Please enter a valid row and column");
                return;
            }
            if (board[row][column] == 1 ) {
                board[row][column] = 'X';
                System.out.println("Hit!");
                TimeUnit.SECONDS.sleep(2);

            } else if (board[row][column] == 0) {
                board[row][column] = '~';
                System.out.println("Miss!");
                TimeUnit.SECONDS.sleep(2);
            } else {
                System.out.println("You have already fired at this cell.");
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
