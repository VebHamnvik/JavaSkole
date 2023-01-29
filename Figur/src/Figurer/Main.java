package Figurer;

public class Main {
    public static void main(String[] args) {
        //Rektangel objekt
        Rektangel rektangel1 = new Rektangel(4, 5);
        Sirkel sirkel1 = new Sirkel(17);
        Kvadrat kvadrat1 = new Kvadrat(2);

        //Skrive ut info om rektangel
        System.out.println(rektangel1.toString() + "\t\tAreal: " + rektangel1.areal() + "\t\tOmkrets: " + rektangel1.omkrets());
        System.out.println(sirkel1.toString() + "\t\tAreal: " + sirkel1.areal() + "\t\tOmkrets: " + sirkel1.omkrets()
         + "\t\tDiameter: " + sirkel1.beregnDiameter());
        System.out.println(kvadrat1.toString() + "\t\tAreal: " + kvadrat1.areal() + "\t\tOmkrets: " + kvadrat1.omkrets());

        if (erStorre(rektangel1, sirkel1))
            System.out.println(rektangel1 + " er størst");
        else
            System.out.println(sirkel1 + " er størst");

        
    }

    public static boolean erStorre(Figur figur1, Figur figur2) {
        return figur1.areal() > figur2.areal();
    }
}
