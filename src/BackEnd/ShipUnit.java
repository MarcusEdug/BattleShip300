package BackEnd;/*  Klasskommentar:
*      */

public class ShipUnit {

    // Variabler
    private String name;
    private boolean active;
    private int life;
    private int shipLenght;
    private boolean test;
    private boolean horizontal;

    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;


    // Konstruktor
    public ShipUnit(String name, int shipLenght){
        this.name = name;
        this.shipLenght = shipLenght;
        life = shipLenght;
        test = false;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getShipLenght() {
        return shipLenght;
    }

    public void setShipLenght(int shipLenght) {
        this.shipLenght = shipLenght;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
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
