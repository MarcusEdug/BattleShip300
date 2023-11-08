package BackEnd;/*  Klasskommentar:
*      */

public class ShipUnit {

    private String name;
    private int life;
    private boolean active; // True = Skeppet har liv kvar.   False = Skeppet har inget liv kvar
    private int shipLenght;
    private boolean testPlace;  // För utplacering på kartan, true = placerats & false = inte utplacerat
    private boolean horizontal; // True = Horisontellt skepp.  False =  Vertikalt skepp.

    // Koordinaterna för skeppet
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;


    public ShipUnit(String name, int shipLength){
        this.name = name;
        this.shipLenght = shipLength;
        life = shipLenght;
        testPlace = false;
    }


    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public int getShipLenght() {
        return shipLenght;
    }

    public void setShipLenght(int shipLenght) {
        this.shipLenght = shipLenght;
    }

    public boolean isTestPlace() {
        return testPlace;
    }

    public void setTest(boolean test) {
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


    // Metoder

    public void hitShip(){
        life--;
        if(life == 0){
            deactivateShip();
        }
    }

    public void deactivateShip(){
        active = false;
    }




}
