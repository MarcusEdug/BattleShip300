package BackEnd;

import FrontEnd.Fire;

public class BackEndMap implements SystemBord {
    private int XRow;
    private char YRowChar;
    private int YRowInt;
    Fire fire = new Fire();

    public void createEndMap(int XRowValue, int YRowValue){

            for (int y = 0; y < XRowValue; y++) {
                for (int x = 0; x < YRowValue; x++) {
                    array[x][y] = "i";
                }
            }
    }
    public void showEndMap(int XRowValue, int YRowValue){
        for (int y = 0; y < XRowValue; y++) {
            for (int x = 0; x < YRowValue; x++) {
                System.out.print(array[x][y] + " " );
            }
            System.out.println(" ");

        }
    }
    public void bout51 (){
        array[0][1] = "s";
        array[0][2] = "s";
        array[0][3] = "s";
        array[0][4] = "s";
        array[0][5] = "s";
        array[0][6] = "s";
        array[0][7] = "s";
        array[0][8] = "s";
    }
    public String checkValue(int x, int y){
        //dennes uppgift blir att kolla om det är en träff eller inte,
        // Antingen returnerar vi träff/miss,
        return array[x][y];
    }


    // MS,FK,AR
    public void hitInput (String input){
        fire.fireRandom(XRowValue, YRowValue);
        XRow = Character.getNumericValue(input.charAt(0));
        YRowChar = input.charAt(1);
        covertYCharToYint(YRowChar);


        if (array[XRow][YRowInt].equals("s")){
            System.out.println("Hit!");

            array[XRow][YRowInt] = "h";
        }
        else {
            System.out.println("Miss!");
            array[XRow][YRowInt] = "m";
        }
    }
    //AR
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

    //AR
    public int getXRow() {
        return XRow;
    }

    //AR
    public void setXRow(int XRow) {
        this.XRow = XRow;
    }

    //AR
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

