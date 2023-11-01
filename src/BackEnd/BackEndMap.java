package BackEnd;

public class BackEndMap implements SystemBord {
    private int XRow;
    private char YRowChar;
    private int YRowInt;

    public void endMap(int XRowValue, int YRowValue){

            for (int x = 0; x < XRowValue; x++) {
                for (int y = 0; y < YRowValue; y++) {
                    array[x][y] = "i";
                }
            }
    }
    public void showEndMap(int XRowValue, int YRowValue){
        for (int x = 0; x < XRowValue; x++) {
            for (int y = 0; y < YRowValue; y++) {
                System.out.print(array[x][y] + " " );
            }
            System.out.println(" ");

        }
    }
    public void hit (String inPut){
        XRow = Character.getNumericValue(inPut.charAt(0));
        System.out.println(XRow);
        YRowChar = inPut.charAt(1);
        System.out.println(YRowChar);
        covertYCharToYint(YRowChar);
        System.out.println(YRowInt);

        array[XRow][YRowInt] = "h";
    }
    public int covertYCharToYint(char y){
        if (y == 'a'){
            YRowInt = 0;
            return YRowInt;
        }
        else if (y == 'b'){
            YRowInt = 1;
            return YRowInt;
        }
        else if (y == 'c'){
            YRowInt = 2;
            return YRowInt;
        }
        else if (y == 'd'){
            YRowInt = 3;
            return YRowInt;
        }
        else if (y == 'e'){
            YRowInt = 4;
            return YRowInt;
        }
        else if (y == 'f'){
            YRowInt = 5;
            return YRowInt;
        }
        else if (y == 'g'){
            YRowInt = 6;
            return YRowInt;
        }
        else if (y == 'h'){
            YRowInt = 7;
            return YRowInt;
        }
        else if (y == 'i'){
            YRowInt = 8;
            return YRowInt;
        }
        else {
            YRowInt = 9;
            return YRowInt;
        }
    }

    public int getXRow() {
        return XRow;
    }

    public void setXRow(int XRow) {
        this.XRow = XRow;
    }

    public char getYRowChar() {
        return YRowChar;
    }

    public void setYRowChar(char YRowChar) {
        this.YRowChar = YRowChar;
    }

    public int getYRowInt() {
        return YRowInt;
    }

    public void setYRowInt(int YRowInt) {
        this.YRowInt = YRowInt;
    }
}

