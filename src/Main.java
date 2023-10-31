import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        try {
            while(true) {
                System.out.println("Välkommen! Skriv in en mening eller skriv quit om du vill avsluta: ");
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Du skrev: " + text);

                if(text.equals("quit")) {
                    System.out.println("Hejdå!");
                    TimeUnit.SECONDS.sleep(3);
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}