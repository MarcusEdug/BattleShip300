import java.io.IOException;

public class ClientMain {

    public static void main (String[] args) throws IOException {
        MyThread client = new MyThread();
        client.connect();

    }
}
