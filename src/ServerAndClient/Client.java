package ServerAndClient;

import BackEnd.BackEndMap;
import BackEnd.Ship;
import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;
import ServerAndClient.ClientThread;

import java.io.*;
import java.net.Socket;

public class Client implements SystemBord {


    private BufferedReader reader;
    private PrintWriter writer;
    private boolean gameIsRunning = true;
    //BackEndMap backEndMap = new BackEndMap();
    //Fire fire = new Fire();
    ChangeColor changeColor = new ChangeColor();
    //MyThread2 myThread2 = new MyThread2();

    //Thread mainThread = new Thread(myThread2);
    ClientThread clinetTread;
    Thread clientMainThread;
    //ServerThread myThread3 = new ServerThread();
    //Thread Thread2 = new Thread(myThread3);

    //String shotOut;
    //String shotIn;

    //Ship ship = new Ship();

    //Skapar en socket för att koppla upp till servern
    //samt skapar utrymme för att ha kontakt med servern genom strängdata
    public void connect() throws IOException {
        try {
            Socket socket = new Socket("localhost", 8080); //Skapar koppling till en port
            System.out.println("Ansluten till servern");

            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println(reader.readLine());
            clinetTread = new ClientThread(writer, reader);
        } catch (IOException e) {
            System.out.println("Kunde inte ansluta på grund av: " + e.getMessage());
        }

        //backEndMap.createEndMap(XRowValue,YRowValue);

       /* ship.createShipUnits();
        System.out.println("har jag fastnat!");
        ship.placeShipsOnMap(array);

        System.out.println("Vi har skapa ship och 2d array");

        */

        clientMainThread = new Thread(clinetTread);
        clientMainThread.start();
       /* while (gameIsRunning) {



            shotOut = fire.fireOutput(XRowValue, YRowValue);
            System.out.println("out " + shotOut);


            if (reader.ready()){
                shotIn = reader.readLine();
                System.out.println("In " + shotIn);
            }


            //backEndMap.delyTheGame();
            Scanner my = new Scanner(System.in);
            System.out.println("skriv");
            int test = my.nextInt();
            if (test == 1){
                gameIsRunning = false;
            }
        }*/
    }
    //Metod för att kolla om spelet är igång
    /*
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
                    String outputText = checkIfHitAndCreateReply(incomingMessage);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Kunde inte pausa på grund av: " + e.getMessage());
                    }
                    System.out.println(outputText);
                    writer.println(outputText);
                }
    public String checkIfHitAndCreateReply(String input) {


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
