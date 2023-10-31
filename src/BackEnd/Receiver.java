package BackEnd;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private int XRowValue;
    private String YRowValue;
    private List<Integer> XRowList = new ArrayList<>();
    private List<Character> YRowList = new ArrayList<>();

    public void addToYRow(){
        for (char c = 'A'; c <= 'J' ; ++c){
            YRowList.add(c);
        }
    }
    public void addToXrow(){
        for (int i = 0; i<10; i++){
            System.out.println(i);
        }
    }
}
