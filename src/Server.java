import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    public void connect() {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Inväntar anslutning till client...");
            socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader= new BufferedReader(inputStreamReader);
            System.out.println("Anslutning upprättad!");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("Välkommen till servern!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
