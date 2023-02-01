package Figurer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Rektangel objekt
        Rektangel rektangel1 = new Rektangel(4, 5);
        Sirkel sirkel1 = new Sirkel(17);
        Kvadrat kvadrat1 = new Kvadrat(2);

        //Skrive ut info om rektangel
        System.out.println("\n************Objektene************");
        System.out.println(rektangel1.toString() + "\t\tAreal: " + rektangel1.areal() + "\t\tOmkrets: " + rektangel1.omkrets());
        System.out.println(sirkel1.toString() + "\t\tAreal: " + sirkel1.areal() + "\t\tOmkrets: " + sirkel1.omkrets()
         + "\t\tDiameter: " + sirkel1.beregnDiameter());
        System.out.println(kvadrat1.toString() + "\t\tAreal: " + kvadrat1.areal() + "\t\tOmkrets: " + kvadrat1.omkrets());

        System.out.println("\n************Hvem er størst?************");
        if (Figurer.erStorre(rektangel1, sirkel1))
            System.out.println(rektangel1 + " er størst");
        else
            System.out.println(sirkel1 + " er størst");

        ArrayList<Figurer> figurListe = new ArrayList <> ();

        figurListe.add(rektangel1);
        figurListe.add(sirkel1);
        figurListe.add(kvadrat1);
        figurListe.add(new Rektangel(5, 10));
        figurListe.add(new Sirkel(5));

        System.out.println("\n************Elementer i ArrayList************");
        for (int i = 0; i < figurListe.size(); i++) {
            Figurer enFigur =figurListe.get(i);

            System.out.println(enFigur);
        }

        
    }
}
