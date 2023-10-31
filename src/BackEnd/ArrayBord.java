package BackEnd;

public class ArrayBord {
    int[][] arr;
    public ArrayBord(int XRowValue, int YRowValue){
            arr = new int[XRowValue][YRowValue];

            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < YRowValue; y++) {
                    arr[x][y] = (x*10)+y;
                }
            }
            for (int x = 0; x < XRowValue; x++) {
                for (int y = 0; y < YRowValue; y++) {
                    System.out.print(arr[x][y] + " " );
                }
                System.out.println(" ");

        }
    }
}

