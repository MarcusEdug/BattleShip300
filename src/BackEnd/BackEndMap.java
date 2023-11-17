package BackEnd;

public class BackEndMap implements SystemBoard {
    public void createEndMap(int XRowValue, int YRowValue){

            for (int y = 0; y < XRowValue; y++) {
                for (int x = 0; x < YRowValue; x++) {
                    array[y][x] = "i";
                    arrayEnemy[y][x] = "i";
                }
            }
    }
    public void showEndMap(int XRowValue, int YRowValue){
        for (int y = 0; y < XRowValue; y++) {
            for (int x = 0; x < YRowValue; x++) {
                System.out.print(array[y][x] + " " );
            }
            System.out.println(" ");

        }
    }

    //Kanske flyttas!
    public void delyTheGame(int delay){
        if(delay == 0){
            try {
                Thread.sleep(0);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else {
            try {
                Thread.sleep(delay * 100);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

