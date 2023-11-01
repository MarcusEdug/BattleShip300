import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    //Skapar en serverSocket för klienten att koppla upp sig till
    //samt skapar utrymme för att skapa och läsa in svar från klient med strängdata
    public void connect() {
        try  {
            serverSocket = new ServerSocket(8080);
            System.out.println("Inväntar anslutning till client...");
            socket = serverSocket.accept();

            //Input
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader= new BufferedReader(inputStreamReader);
            System.out.println("Anslutning upprättad!");

            //Output
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("Välkommen till servern!");

            String incomingMessage = "";
            String outMessage = "";

            while (true) {
                incomingMessage = reader.readLine();
                System.out.println("Klienten = " + incomingMessage);
                writer.println(outMessage);
                System.out.println("Väntar på klientens tur att svara");
                break;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
