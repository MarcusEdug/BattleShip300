import FrontEnd.GameBoard;
import BackEnd.SystemBord;
import BackEnd.BackBord;
import FrontEnd.Fire;
import javafx.application.Application;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //BackBord my = new BackBord();
       //my.runBackEnd();
       // Player player1 = new Player();
        Fire fire = new Fire();
        Application.launch(GameBoard.class, args);




    }

}