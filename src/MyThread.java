public class MyThread implements Runnable {
    //Kan "extenda" en annan klass om det behövs

    @Override
    public void run() {
        //Här kan metoden för att starta upp spelplanen finnas
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tråden är klar");
    }
}
