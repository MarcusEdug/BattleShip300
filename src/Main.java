
import BackEnd.BackBord;
import FrontEnd.Fire;
import javafx.application.Application;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        //Player player1 = new Player();
        //Fire fire = new Fire();

        MyThread runnable1 = new MyThread();
        Thread thread1 = new Thread(runnable1);


        MyThread2 runnable2 = new MyThread2();
        Thread thread2 = new Thread(runnable2);

        thread1.setPriority(10); //thread1 kommer alltid att köras först (ex client)
        thread1.start();
        //thread1.join(2000); //Skapar en delay för thread2. Kommer att avslutas 2 sekunder efter thread1 är klar.
        thread2.start();


    }

}

