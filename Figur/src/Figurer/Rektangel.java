package Figurer;

public class Rektangel extends Figurer{
    //Oprette instansvariabler
    private double side1, side2;

    //Opprette konstruktør
    public Rektangel(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    //Override areal
    @Override
    public double areal() {
        return side1 * side2;
    }

    //Override omkrets
    @Override
    public double omkrets() {
        return 2 * side1 + 2 * side2;
    }

    //@Override toString
    @Override
    public String toString() {
        return "Rektangel med sidene: " + side1 + ", " + side2;
    }
}
