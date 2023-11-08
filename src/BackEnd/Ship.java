package BackEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*  Klasskommentar:
*   Innehåller lista med skepp för spelet samt metoder för att hantera skeppobjekten
 */

 /*
     ***   Båtar i Spelet:  ***
       1 - Hangarfartyg   (5x1)
       2 - Slagskepp      (4x1)
       3 - Kryssare       (3x1)
       4 - Ubåtar         (2x1)
  */

public class Ship {

    private String[] nameList = {"Hangarfartyg", "Slagskepp", "Kryssare", "Ubåt"};  // Sorters skepp
    private int[] numOfShips = {1, 2, 3, 4};   // Antal för varje sorts skepp
    private int[] shipLenght = {5, 4, 3, 2};  // Antal rutor skeppet tar upp, samma ordning som namn
    private List<ShipUnit> shipList = new ArrayList<>(); // Lista med skeppsobjekt


    // Tom konstruktor (Evelina Daun)
    public Ship(){}


    // Metoder

    // Metod: Skapa skeppobjekten (Evelina Daun)
    public void createShipUnits(){

        /*
        // Om restart - rensa gamla listan
        if(!shipList.isEmpty()){
            // Tömma listan
        }
         */

        for(int i = 0; i < 4; i++){ // Yttre loop - Antalet skeppsorter
            for(int j = 0; j < numOfShips[i]; j++){ // Inre loop - Antalet specifika skepp
                ShipUnit temp = new ShipUnit(nameList[i], shipLenght[i]);
                shipList.add(temp);
            }
        }
    }

    // Metod: Placera ut skeppen på kartan  (Evelina Daun)
    // @param: Backend array för kartan
    // @return: Backend array för kartan inkl utplacerade skeppen
    public String[][] placeShipsOnMap(String[][] array){
        Random random = new Random();
        int size = array.length;

        for (ShipUnit shipUnit : shipList) {    // Gå igenom alla skeppsobjekt
            while (!shipUnit.isTestPlace()) {        // Tills att skeppet är utplacerat på kartan

                int startX = random.nextInt(size);
                int startY = random.nextInt(size);
                int endX = 0;
                int endY = 0;


                // För att kontrollera området runt skeppet
                /*
                     |*                    rowBefore(x-1)                    *|
                     |colBefore(y-1)     (sx/sy)SKEPP(ex/ey)     colAfter(y+1)|
                     |*                     rowAfter(x+1)                    *|
                 */

                int rowBefore;
                int rowAfter;
                int colBefore;
                int colAfter;

                if (startX == 0) {
                    rowBefore = 0;
                } else {
                    rowBefore = startX - 1;
                }

                if (startY == 0) {
                    colBefore = startY;
                } else {
                    colBefore = startY - 1;
                }


                boolean horizontal = random.nextBoolean();  // True = Horisontell  &  False = Vertikal
                boolean testContainsS = false;              // Inom koordinaterna.  True: Om s finns    False: Om s inte finns
                boolean testSpaceAround = false;            // Runt koordinaterna.  True: Om s finns    False: Om s inte finns


                if (horizontal) {  // Horisontella skepp  Y -> Y  ( x ändras inte )
                    if (startY + shipUnit.getShipLenght() <= size) { // Om skeppet får plats
                        endX = startX;
                        endY = startY + shipUnit.getShipLenght() - 1;

                        // Kontrollera att själva koordinaterna inte innehåller S
                        for (int k = startY; k <= endY; k++) {
                            if (array[startX][k].equals("s")) {
                                testContainsS = true;
                                break;
                            }
                        }

                        // Om s inte finns // Kontrollera avståndet runt skeppen
                        if (!testContainsS) {

                            if (endX == (size - 1)) {
                                rowAfter = endX;
                            } else {
                                rowAfter = endX + 1;
                            }

                            if (endY == (size - 1)) {
                                colAfter = endY;
                            } else {
                                colAfter = endY + 1;
                            }

                            // Metod - skicka in boolean, row col före och efter


                            for (int a = colBefore; a <= colAfter; a++) {
                                if (array[rowBefore][a].equals("s")) { // Raden före + en kolumn före och efter
                                    testSpaceAround = true;
                                    break;
                                } else if (array[rowAfter][a].equals("s")) { // Raden efter + en kolumn före och efter
                                    testSpaceAround = true;
                                    break;
                                }
                            }

                            if (array[startX][colBefore].equals("s") || array[startX][colAfter].equals("s")) {
                                testSpaceAround = true;
                            }

                            if (!testSpaceAround) {
                                // Lägga till skeppet i arrayen
                                for (int j = startY; j <= endY; j++) {
                                    array[startX][j] = "s";
                                }

                                // Lägga till koordinaterna i skeppet
                                shipUnit.setxStart(startX);
                                shipUnit.setyStart(startY);
                                shipUnit.setxEnd(endX);
                                shipUnit.setyEnd(endY);

                                shipUnit.setHorizontal(true);
                                shipUnit.setTest(true); // Att skeppet är tillagt
                            }
                        }
                    }
                } else { // Vertikala skepp  X -> X  (y ändras inte)
                    if (startX + shipUnit.getShipLenght() <= size) { // Om Skeppet får plats
                        endX = startX + shipUnit.getShipLenght() - 1;
                        endY = startY;

                        // Kontrollera att själva koordinaterna inte innehåller S
                        for (int k = startX; k <=  endX; k++) {
                            if (array[k][startY].equals("s")) {
                                testContainsS = true;
                                break;
                            }
                        }

                        if (!testContainsS) {

                            if (endY == (size - 1)) {
                                colAfter = endY;
                            } else {
                                colAfter = endY + 1;
                            }

                            if (endX == (size - 1)) {
                                rowAfter = endX;
                            } else {
                                rowAfter = endX + 1;
                            }

                            for (int a = rowBefore; a <= rowAfter; a++) {
                                if (array[a][colBefore].equals("s")) { // Raden före + en kolumn före och efter
                                    testSpaceAround = true;
                                    break;
                                } else if (array[a][colAfter].equals("s")) { // Raden efter + en kolumn före och efter
                                    testSpaceAround = true;
                                    break;
                                }
                            }


                            if (array[rowBefore][startY].equals("s") || array[rowAfter][startY].equals("s")) {
                                testSpaceAround = true;
                            }


                            if (!testSpaceAround) {
                                for (int j = startX; j <= endX; j++) {
                                    array[j][startY] = "s";
                                }

                                // Lägga till koordinaterna i skeppet
                                shipUnit.setxStart(startX);
                                shipUnit.setyStart(startY);
                                shipUnit.setxEnd(endX);
                                shipUnit.setyEnd(endY);

                                shipUnit.setHorizontal(false);
                                shipUnit.setTest(true); // Ändra så att skeppet är tillagt
                            }

                        }
                    }
                }
            } // While loop
        } // For loop

        return array;
    }


    // Metod: Kontrollera området runt skeppet (Evelina Daun)
    public boolean testSpace(boolean horizontal, int rowBefore, int rowAfter, int colBefore, int colAfter){

        // Om Horisontell
        // Om Vertikal

        return true;
    }


    // Metod: Kontrollera om det är något skepp som inte är träffat (Evelina Daun)
    // @return: True = Skepp har liv kvar  False = Skepp har inte liv kvar
    public boolean checkActiveShips(){
        for(ShipUnit s : shipList){
            if(s.isActive()){
                return true;
            }
        }
        return false;
    }

    // Metod: Förändra livet på det skepp som är träffat (Evelina Daun)
    // @param: x och y koordinater för träffade skeppet
    public void hitShipCoordinate(int x, int y){
        ShipUnit temp = findShipUnit(x, y); // Hitta rätt skeppobjekt
        temp.hitShip(); // Förändra skeppobjektet

        // Lägga till att skicka tillbaka skeppets namn om skeppet är träffat helt?

    }

    // Metod: Hitta rätt skepp utifrån x och y koordinat (Evelina Daun)
    // Returnerar skeppobjekt  eller  null om det inte finns något
    public ShipUnit findShipUnit(int x, int y){
        for(ShipUnit ship : shipList){
            boolean horizontal = ship.isHorizontal(); // True = Horisontell, False = Vertikal

            if(horizontal){ // Horisontell
                for(int i = ship.getyStart(); i <= ship.getyEnd(); i++){
                    if(i == y && ship.getxStart() == x){
                        return ship;
                    }
                }
            }else{ // Vertikal
                for(int i = ship.getxStart(); i <= ship.getxEnd(); i++){
                    if(i == x  && ship.getyStart() == y){
                        return ship;
                    }
                }
            }
        }
        return null; // Ändra detta
    }


    // Metod: Återställa spelet och köra igen  ???  // Lägga till om tid ?




} // Slut på Ship Klassen
