package BackEnd;

/*  Klasskommentar:
 *   Innehåller variabler och metod för att hantera enskilda skeppobjekt.
 *   Evelina Daun
 * */

public class ShipUnit {

    private String name;
    private int lifeCounter;
    private int shipLenght;
    private boolean testPlace;   // För utplacering på kartan, true = placerats & false = inte utplacerat
    private boolean horizontal;  // True = Horisontellt skepp.  False =  Vertikalt skepp.

    // Koordinaterna för skeppet
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;


    // Konstruktor (Evelina Daun)
    public ShipUnit(String name, int shipLength){
        this.name = name;
        this.shipLenght = shipLength;
        lifeCounter = shipLenght;
        testPlace = false;
    }


    // Getters & Setters (Evelina Daun)
    public String getName() {
        return name;
    }
    public int getShipLenght() {
        return shipLenght;
    }

    public boolean isTestPlace() {
        return testPlace;
    }

    public void setTestPlace(boolean test) {
        this.testPlace = test;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }


    // Metod: När ett skeppobjekt blir träffat (Evelina Daun)
    public int hitShip(){
        --lifeCounter; // -1 på livräknaren
        return lifeCounter;
    }

}