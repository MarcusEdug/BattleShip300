
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import BackEnd.BackBord;
import FrontEnd.Fire;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        //Player player1 = new Player();
        //Fire fire = new Fire();

        MyThread runnable1 = new MyThread();
        Thread thread1 = new Thread(runnable1);

        MyThread runnable2 = new MyThread();
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread1.join(1000); //Skapar en delay på thread2. Alltså, tråd 1 börjar 1 sekund före tråd 2
        thread2.start();




    }

}

