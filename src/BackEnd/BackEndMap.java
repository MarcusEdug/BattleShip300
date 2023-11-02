package BackEnd;

import FrontEnd.Fire;

public class BackEndMap implements SystemBord {
    private int XRow;
    private char YRowChar;
    private int YRowInt;
    Fire fire = new Fire();

    //Skapar back end kartan (AR)
    public void createEndMap(int XRowValue, int YRowValue){

            for (int y = 0; y < XRowValue; y++) {
                for (int x = 0; x < YRowValue; x++) {
                    array[x][y] = "i";
                }
            }
    }

    // Vissar hur back end kartan ser ut just nu (AR)
    public void showEndMap(int XRowValue, int YRowValue){
        for (int y = 0; y < XRowValue; y++) {
            for (int x = 0; x < YRowValue; x++) {
                System.out.print(array[x][y] + " " );
            }
            System.out.println(" ");

        }
    }

    //test båt (AR)
    public void bout51 (){
        array[0][0] = "s";
        array[0][1] = "s";
        array[0][2] = "s";
        array[0][3] = "s";
        array[0][4] = "s";
        lifeOnBoat.add(5);
        lifeOnBoat.add(5);
        lifeOnBoat.add(5);
        lifeOnBoat.add(5);
        lifeOnBoat.add(5);

    }

    //test båt (AR)
    public void bout52 (){
        array[4][2] = "s";
        array[5][2] = "s";
        array[6][2] = "s";
        lifeOnBoat.add(3);
        lifeOnBoat.add(3);
        lifeOnBoat.add(3);
    }


    //Fixar med Fire metod (AR)
    public void fire (){
            fire.fireRandom(XRowValue, YRowValue);

    }
    // MS,FK,AR
    //SKjuter på kooriderna som kommer in / oklar om vi behöver. Används inte
    public void hitInput (String input){
        XRow = Character.getNumericValue(input.charAt(0));
        YRowChar = input.charAt(1);
        covertYCharToYint(YRowChar);

        if (array[XRow][YRowInt].equals("s")) {
            System.out.println("Hit!");
            array[XRow][YRowInt] = "h";
            lifeOnBoat.remove(0);
        }
        else if (array[XRow][YRowInt].equals("h") || array[XRow][YRowInt].equals("m")){
            hitInput(input);
        }
        else {
            System.out.println("Miss!");
            array[XRow][YRowInt] = "m";
        }
    }

    //Omvanlar Char till int (AR)
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

