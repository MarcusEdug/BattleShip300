package BackEnd;

import java.util.ArrayList;
import java.util.List;

public class BackEndBord {
    private int XRowValue;
    private String YRowValue;
    private List<Integer> XRowList = new ArrayList<>();
    private List<Character> YRowList = new ArrayList<>();
    public BackEndBord(){
        for (char c = 'A'; c <= 'J' ; ++c){
            YRowList.add(c);
        }
        for (int i = 0; i<10; i++){
            XRowList.add(i);
        }
    }
    public void bord (){
        int[][] arr ={ {0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9} };

        for(int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }


    public void writeOutXlist(){
        for(int i = 0; i<XRowList.size(); i++){
            System.out.println(getXRowList(i));

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
