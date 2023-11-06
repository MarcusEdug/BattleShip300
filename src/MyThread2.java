public class MyThread2 implements Runnable{
    //Kan "extend" en annan klass om det behövs.
    @Override
    public void run() {
        //Här kan metoden för att starta spelplan #2 finnas.

        for (int i = 5; i >= 1 ; i--) {
            System.out.println("Tråd nr 2: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tråd nr 2 är klar");
    }
}
