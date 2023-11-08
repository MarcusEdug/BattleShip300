import java.io.IOException;

public class MyThread implements Runnable {
    //Kan "extend" en annan klass om det behövs

    @Override
    public void run() {
        //Här kan metoden för att starta upp spelplan #1 finnas..

        for (int i = 1; i <= 5; i++) {
            System.out.println("Tråd nr 1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tråd nr 1 är klar");
    }
    public void Synchronized(int x, int y) {
        for (int i = 0; i < x; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Synkroniserar trådarna...");
        }
    }
}
