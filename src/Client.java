import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    //Skapar en socket för att koppla upp till servern
    //samt skapar utrymme för att ha kontakt med servern genom strängdata
    public void connect() {
        try {
            //Output
            socket = new Socket("localhost", 8080); //Skapar koppling till ip-adressen
            //OutputStream output = socket.getOutputStream();
            System.out.println("Ansluten till servern");
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true); //Stänger socket automatiskt efter fönstret stängs

            //Input
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            writer.println("Connected...");
            System.out.println(reader.readLine());


            String text = "";
            while (!text.equals("quit")) {
                writer.println();
                String incomingMessage = reader.readLine();
                System.out.println(incomingMessage);
                break;
            }
            socket.close(); //Stänger kommunikationen

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
