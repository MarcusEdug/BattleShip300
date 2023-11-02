import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean gameIsRunning;
    private boolean firstShot;
    private String outGoingMessage;

    //Skapar en socket för att koppla upp till servern
    //samt skapar utrymme för att ha kontakt med servern genom strängdata
    public void connect() throws IOException {
        try {

            Socket socket = new Socket("localhost", 8080); //Skapar koppling till ip-adressen
            System.out.println("Ansluten till servern");


            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);


            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("connected..."); //Skickas till servern

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        while (gameIsRunning) {
            if(firstShot) {
                outGoingMessage = "Jag skjuter på + *koordinat*";
                System.out.println(outGoingMessage);
                writer.println(outGoingMessage);
                firstShot = false;
            } else {
                if(reader.ready()){
                    String incomingMessage = reader.readLine();
                    System.out.println("Servern skjuter på " + incomingMessage);
                    String outoutText = checkIfHitAndCreateReply(incomingMessage);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Kunde inte pause på grund av " + e.getMessage());
                    }
                    System.out.println(outoutText);
                    writer.println(outoutText);
                }
            }
        }
    }
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
                return "Tusan! Du träffade en *TypAvBåt*";
            }
        }
    }
//}
