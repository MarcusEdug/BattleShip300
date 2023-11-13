package BackEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*  Klasskommentar:
*   Innehåller lista med skepp för spelet samt metoder för att hantera skeppobjekten.
*   Evelina Daun
*/

 /*        SKEPP I SPELET:
    Antal:  Namn:          Storlek:
    1       Hangarfartyg   (5x1)
    2       Slagskepp      (4x1)
    3       Kryssare       (3x1)
    4       Ubåtar         (2x1)
  */

public class Ship {

    private String[] nameList = {"Hangarfartyg", "Slagskepp", "Kryssare", "Ubåt"};  // Sorters skepp
    private int[] numOfShips = {1, 2, 3, 4};   // Antal för varje sorts skepp
    private int[] shipLenght = {5, 4, 3, 2};  // Antal rutor skeppet tar upp, samma ordning som namn
    private List<ShipUnit> shipList = new ArrayList<>(); // Lista med skeppsobjekt


    // Tom konstruktor (Evelina Daun)
    public Ship(){}


    // Metoder

    // Metod: Återställa spelet och köra igen  ???  // Lägga till om tid ?
    // Metod: Dela upp sökandet av koordinaterna i mindre delar  // Om tid när spelet är kopplat så det syns att det fungerar

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
    public String[][] placeShipsOnMap(String[][] array){ /*
        Random random = new Random();
        int size = array.length;

        for (ShipUnit shipUnit : shipList) {         // Gå igenom alla skeppsobjekt
            while (!shipUnit.isTestPlace()) {        // Tills att skeppobjektet är utplacerat på kartan

                // Random placering för skeppet
                int startX = random.nextInt(size);
                int startY = random.nextInt(size);
                int endX = 0;
                int endY = 0;

                // För att kontrollera området runt skeppet
                /*   |                     rowBefore(x-1)                     |
                     |colBefore(y-1)     (sx/sy)SKEPP(ex/ey)     colAfter(y+1)|
                     |                     rowAfter(x+1)                      |

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


                if (horizontal) {  // Horisontella skepp  Y -> Y
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

                        if (!testContainsS) { // Om koordinaterna inte innehåller s
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

                            // Raderna runt skeppet
                            for (int a = colBefore; a <= colAfter; a++) {
                                if (array[rowBefore][a].equals("s")) {
                                    testSpaceAround = true;
                                    break;
                                } else if (array[rowAfter][a].equals("s")) {
                                    testSpaceAround = true;
                                    break;
                                }
                            }

                            // Kolumnerna före och efter
                            if (array[startX][colBefore].equals("s") || array[startX][colAfter].equals("s")) {
                                testSpaceAround = true;
                            }

                            if (!testSpaceAround) {
                                for (int j = startY; j <= endY; j++) { // Lägga till skeppet i arrayen
                                    array[startX][j] = "s";
                                }

                                // Lägga till koordinaterna i skeppobjektet
                                shipUnit.setxStart(startX);
                                shipUnit.setyStart(startY);
                                shipUnit.setxEnd(endX);
                                shipUnit.setyEnd(endY);

                                shipUnit.setHorizontal(true);
                                shipUnit.setTestPlace(true); // Att skeppet är tillagt
                            }
                        }
                    }
                } else { // Vertikala skepp  X -> X
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

                        if (!testContainsS) { // Om koordinaterna inte innehåller s
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

                            // Kolumnerna runt skeppet
                            for (int a = rowBefore; a <= rowAfter; a++) {
                                if (array[a][colBefore].equals("s")) {
                                    testSpaceAround = true;
                                    break;
                                } else if (array[a][colAfter].equals("s")) {
                                    testSpaceAround = true;
                                    break;
                                }
                            }

                            // Raden före och efter skeppet
                            if (array[rowBefore][startY].equals("s") || array[rowAfter][startY].equals("s")) {
                                testSpaceAround = true;
                            }

                            if (!testSpaceAround) {
                                for (int j = startX; j <= endX; j++) { // Lägga till skeppet i arrayen
                                    array[j][startY] = "s";
                                }

                                // Lägga till koordinaterna i skeppet
                                shipUnit.setxStart(startX);
                                shipUnit.setyStart(startY);
                                shipUnit.setxEnd(endX);
                                shipUnit.setyEnd(endY);

                                shipUnit.setHorizontal(false);
                                shipUnit.setTestPlace(true); // Ändra så att skeppet är tillagt
                            }
                        }
                    }
                }
            }
        }*/
        array[0][0]="s";
        return array;
    }


    // Metod: Kontrollera om det finns skeppobjekt med liv kvar (Evelina Daun)
    // @return: True = Skepp har liv kvar  False = Inget skeppobjekt har inte liv kvar
    public boolean checkActiveShips(){
        for(ShipUnit s : shipList){
            if(s.isActive()){
                return true;
            }
        }
        return false;
    }


    // Metod: Förändra livet på det skepp som är träffat (Evelina Daun)
    // @param: X och y koordinater för träffade skeppet
    public void hitShipCoordinate(int x, int y){
        ShipUnit temp = findShipUnit(x, y); // Hitta rätt skeppobjekt

        if(!temp.getName().isEmpty()){
            temp.hitShip(); // Förändra skeppobjektet
        }

        // Lägga till att skicka tillbaka skeppets namn om skeppet är träffat helt?
        // Om skeppet är helt träffat skicka - getName
        // Om skeppet inte är helt träffat -
    }


    // Metod: Hitta rätt skepp utifrån x och y koordinat (Evelina Daun)
    // @return: skeppobjekt  eller  null om det inte finns något
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
        return new ShipUnit("", 0); // Skicka tomt objekt ifall skeppet inte finns
    }

}