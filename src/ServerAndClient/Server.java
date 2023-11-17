package ServerAndClient;

import BackEnd.SystemBoard;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements SystemBoard {
    private BufferedReader reader;
    private PrintWriter writer;

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

            //serverThread = new ServerThread(writer, reader, delay);


        }
        catch (IOException e) {
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

