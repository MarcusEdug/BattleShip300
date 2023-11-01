import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    public void connect() {
        try {
            socket = new Socket("localhost", 8080);
            System.out.println("Ansluten till servern");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            System.out.println(reader.readLine());
            writer.println("Connected");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
