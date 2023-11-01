package BackEnd;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Hit implements SystemBord{
    Scanner myScanner = new Scanner(System.in);
    String userInPut;
    int XRow;
    char YRowChar;
    int YRowInt;

    public void hitBord (String inPut) {
        System.out.println("Vart på borden vill du skjuta? skriv som \" 6c \"");
        //userInPut = myScanner.nextLine();
        userInPut = "7c";
        covertCoordinates(userInPut);

    }

    public Array[][] covertCoordinates (String xy) {
        XRow = Character.getNumericValue(xy.charAt(0));
        System.out.println(XRow);
        YRowChar = xy.charAt(1);
        System.out.println(YRowChar);
        covertYCharToYint(YRowChar);
        System.out.println(YRowInt);

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


}
