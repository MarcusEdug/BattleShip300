package ServerAndClient;

import BackEnd.SystemBoard;
import FrontEnd.ChangeColor;

import java.io.*;
import java.net.Socket;

public class Client implements SystemBoard {

    private BufferedReader reader;
    private PrintWriter writer;

    //Metod: Skapar en koppling med Serven (MS)
    public void connect() throws IOException {
        try {
            Socket socket = new Socket("localhost", 8080); //Skapar koppling till en port
            System.out.println("Ansluten till servern");

            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Kunde inte ansluta på grund av: " + e.getMessage());
        }

    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
}
