package ServerAndClient;

import BackEnd.SystemBoard;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements SystemBoard {

    private int delay;

    private BufferedReader reader;
    private PrintWriter writer;
    private boolean gameIsRunning = true;
    //BackEndMap backEndMap = new BackEndMap();
    //Fire fire = new Fire();
    //ChangeColor changeColor = new ChangeColor();
    //MyThread2 myThread2 = new MyThread2();

    //Thread mainThread = new Thread(myThread2);
    ServerThread serverThread;
    Thread serverMainTread;
    //String shotOut;
    //String shotIn;
    //Ship ship = new Ship();

    //Skapar en serverSocket för klienten att koppla upp sig till
    //samt skapar utrymme för att skapa och läsa in svar från klient med strängdata
   /* public Server(int delay){
        this.delay = delay;
    }

    */
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


        } catch (IOException e) {
            System.out.println("Kunde inte ansluta på grund av: " + e.getMessage());
        }
        /*backEndMap.createEndMap(XRowValue,YRowValue);

        ship.createShipUnits();
        System.out.println("har jag fastnat!");
        ship.placeShipsOnMap(array);

        System.out.println("Vi har skapa ship och 2d array");

         */

        //serverMainTread = new Thread(serverThread);
       // serverMainTread.start();
        //shotIn = reader.readLine();
        //System.out.println("In " + shotIn);

        /*while (gameIsRunning) {
            if (reader.ready()){
                shotIn = reader.readLine();
                System.out.println("In " + shotIn);
            }


            shotOut = fire.fireOutput(XRowValue, YRowValue);

            System.out.println("out " + shotOut);
            writer.println(shotOut);


            //backEndMap.delyTheGame();

            Scanner my = new Scanner(System.in);
            System.out.println("skriv");
            int test = my.nextInt();
            if (test == 1){
                gameIsRunning = false;
                }
            }*/


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
    //Metod för att kolla om spelet är igång
    /*public String checkIfHitAndCreateReply(String input) {
        if (input.equals("Jag förlorade")) {
            gameIsRunning = false;
            return "Yes! Jag vann!";
        /*} else {
            //Här ska det in en metod som gäller om alla båtar är sänkta
            if (allShipsSunken) {
                gameIsRunning = false;
                return "Jag förlorade";

            } else {
                     return "Tusan! Du träffade en båt!";
            }
        }

     */
    }

