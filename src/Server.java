import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private boolean gameIsRunning;
    private BufferedReader reader;
    private PrintWriter writer;

    //Skapar en serverSocket för klienten att koppla upp sig till
    //samt skapar utrymme för att skapa och läsa in svar från klient med strängdata
    public void connect() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Inväntar anslutning till client...");

            Socket socket = serverSocket.accept();
            System.out.println("Anslutning upprättad!");

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Välkommen till servern!"); //Skickas till klienten
            System.out.println("nu är jag ansluten");
            writer.println("01"); //Skickas till klienten
            System.out.println("Jag har skjuttigt");
            String incomingMessage = reader.readLine();
            System.out.println("Klienten skjuter på: " + incomingMessage);

        } catch (IOException e) {
            System.out.println("Kunde inte ansluta på grund av: " + e.getMessage());
        }
        /*while (gameIsRunning) {
            if (reader.ready()) {
                String incomingMessage = reader.readLine();
                System.out.println("Klienten skjuter på: " + incomingMessage);
                //String outputText = checkIfHitAndCreateReply(incomingMessage);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Kunde inte pausa på grund av: " + e.getMessage());
                }
            }
        }*/
    }
    //Metod för att kolla om spelet är igång
    public String checkIfHitAndCreateReply(String input) {
        if (input.equals("Jag förlorade")) {
            gameIsRunning = false;
            return "Yes! Jag vann!";
        /*} else {
            //Här ska det in en metod som gäller om alla båtar är sänkta
            if (allShipsSunken) {
                gameIsRunning = false;
                return "Jag förlorade";*/

            } else {
                     return "Tusan! Du träffade en båt!";
            }
        }
    }
//}
