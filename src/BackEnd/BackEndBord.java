package BackEnd;

import java.util.ArrayList;
import java.util.List;

public class BackEndBord {
    private int XRowValue = 10;
    private int YRowValue = 10;
    private List<Integer> XRowList = new ArrayList<>();
    private List<Character> YRowList = new ArrayList<>();
    public BackEndBord(){
        for (char c = 'A'; c <= 'J' ; ++c){
            YRowList.add(c);
        }
        for (int i = 0; i<100; i++){
            XRowList.add(i);
        }
    }
    public void bord () {
        ArrayBord bord = new ArrayBord(XRowValue,YRowValue);
    }



    public void writeOutXlist(){
        for(int i = 0; i<XRowList.size(); i++){
            getXRowList(i);

        }
    }
    public void writeOutYlist(){
        for(int i = 0; i<YRowList.size(); i++) {
            System.out.println(getYRowList(i));
        }
    }



    public int getXRowList(int XListIndex) {
        return XRowList.get(XListIndex);
    }
    public char getYRowList(int YListIndex) {
        return YRowList.get(YListIndex);
    }
    public void setXRowList (int setXRowList){
        XRowList.add(setXRowList);
    }
    public void setYRowList (char setYRowList){
        YRowList.add(setYRowList);
    }
}
