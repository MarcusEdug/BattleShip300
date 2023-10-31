import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        TestBåtar battleship = new TestBåtar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row and column to fire (0 - 4): "); // Båtarna ligger på index, alltså om gissning "3 2", visas 4e raden, 3e kolumnen
        while (true) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            battleship.fire(row, column);

            //Skriv ut spelplan för att se hits och missar
            for (int i = 0; i < battleship.getBoard().length; i++) {
                for (int j = 0; j < battleship.getBoard()[i].length; j++) {
                    System.out.println(battleship.getBoard()[i][j] + " ");

                }
                System.out.println();
            }
            System.out.println("Enter a row and column to fire (0 - 4): ");

           /* try {
                while (true) {
                    System.out.println("Välkommen! Skriv in en mening eller skriv quit om du vill avsluta: ");
                    String text = scanner.nextLine();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Du skrev: " + text);

                    if (text.equals("quit")) {
                        System.out.println("Hejdå!");
                        TimeUnit.SECONDS.sleep(3);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }*/
        }
    }
}