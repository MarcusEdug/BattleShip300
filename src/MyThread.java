import BackEnd.BackEndMap;
import BackEnd.Ship;
import BackEnd.SystemBord;
import FrontEnd.ChangeColor;
import FrontEnd.Fire;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyThread implements Runnable, SystemBord {
    //Kan "extend" en annan klass om det behövs
    BackEndMap backEndMap = new BackEndMap();
    Fire shotFire = new Fire();
    ChangeColor changeColor = new ChangeColor();
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean gameIsRunning;
    private boolean firstShot;
    private String outGoingMessage;

    String incomingMessage;
    Socket socket;
    InputStream inputStream;
    InputStreamReader inputStreamReader;

    String test ="s";
    Scanner myScanner = new Scanner(System.in);

    Ship ship;

    public void connect() throws IOException {
        try {
            socket = new Socket("localhost", 8080); //Skapar koppling till en port
            System.out.println("Ansluten till servern");

            inputStream = socket.getInputStream();

            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("client connected..."); //Skickas till servern

        } catch (IOException e) {
            System.out.println("Kunde inte ansluta på grund av: " + e.getMessage());
        }
    }
    @Override
    public void run()  {
        backEndMap.createEndMap(XRowValue,YRowValue);
        ship = new Ship();
        ship.createShipUnits();
        System.out.println("båtar skapade");
        ship.placeShipsOnMap(array);
        changeColor.clientColor();
        System.out.println("Nu är dom placerade");
        backEndMap.showEndMap(XRowValue,YRowValue);
        while (!ship.checkActiveShips()) {
            String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
            writer.println(shipFire);
            System.out.println("De har skjutist");
            try {
                incomingMessage = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int valueX = Character.getNumericValue(incomingMessage.charAt(0));
            int valueY = Character.getNumericValue(incomingMessage.charAt(1));
            //System.out.println("nu har fireinput tagit emot skottet");
            ship.hitShipCoordinate(valueX,valueY);
            System.out.println("nu har ship tagit emot skottet");
            changeColor.colorChanges(valueX,valueY);
            //System.out.println("nu ändras färgen");
            backEndMap.showEndMap(XRowValue,YRowValue);
        }
        System.out.println("Won");
        //Kör  hela BackEnd programet (AR)

    }
    public void runBackEnd() {
        backEndMap.createEndMap(XRowValue,YRowValue);
        ship = new Ship();
        ship.createShipUnits();
        //System.out.println("båtar skapade");
        try{

            ship.placeShipsOnMap(array);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //System.out.println("Nu är dom placerade");
        backEndMap.showEndMap(XRowValue,YRowValue);
        while (!ship.checkActiveShips()) {
            String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
            //System.out.println("De har skjutist");
            int valueX = Character.getNumericValue(shipFire.charAt(0));
            int valueY = Character.getNumericValue(shipFire.charAt(1));
            ship.hitShipCoordinate(valueX,valueY);
            //System.out.println("nu har ship tagit emot skottet");
            shotFire.fireInput(shipFire);
            //System.out.println("nu har fireinput tagit emot skottet");
            changeColor.colorChanges(valueX,valueY);
            //System.out.println("nu ändras färgen");
            backEndMap.showEndMap(XRowValue,YRowValue);
        }
        System.out.println("Won");



    }
    public void hitInput (){
        String shipFire = shotFire.fireOutput(XRowValue,YRowValue);
        int valueX = Character.getNumericValue(shipFire.charAt(0));
        int valueY = Character.getNumericValue(shipFire.charAt(1));
        ship.hitShipCoordinate(valueX,valueY);
        shotFire.fireInput(shipFire);
        changeColor.colorChanges(valueX,valueY);


    }

    //Metod för att kolla om spelet är igång
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
            return "Tusan! Du träffade en båt!";
        }
    }
}
