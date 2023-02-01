package Figurer;

public class Figurer {
    public double areal() {
        return 0;
    }

    public double omkrets() {
        return 0;
    }

    //Ikke static metoder trenger en instans for å kjøre
    //Static metoder trenger ikke det
    public static boolean erStorre(Figurer figur1, Figurer figur2) {
        return figur1.areal() > figur2.areal();
    }
}
