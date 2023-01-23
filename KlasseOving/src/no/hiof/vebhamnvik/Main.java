package no.hiof.vebhamnvik;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Fly boeing737 = new Fly("Boeing-737", 154);
        Fly sr71 = new Fly("SR-71", 2);
        Fly airbusa380 = new Fly("Airbus A380", 525);

        /* Lager en array og populeler plassene. Når man lager en array må man erklære hvor stor den skal være
        Man kan også opprette et objekt når man setter inn i array slik som på flyArray[3]
         */
        Fly[] flyArray = new Fly[4];
        flyArray[0] = boeing737;
        flyArray[1] = sr71;
        flyArray[2] = airbusa380;
        flyArray[3] = new Fly("Boeing-747", 480);

        for(int i = 0; i < flyArray.length; i++) {
            Fly etFly = flyArray[i];
            System.out.println(etFly.getModell());
        }
        //Lager en ArrayList. Trenger ikke definiere størrelsen når man lager den og man kan enkelt endre den etterpå
        ArrayList<Fly> flyArrayList = new ArrayList<>();
        flyArrayList.add(boeing737);
        flyArrayList.add(sr71);
        flyArrayList.add(airbusa380);

        System.out.println("\nFly fra ArrayList:");
        for (int j = 0; j < flyArrayList.size(); j++) {
            System.out.println(flyArrayList.get(j).getModell());
        }

        /*
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();

        System.out.println("Det er " + boeing737.getSeter() + " seter på flyet " + boeing737.getModell());
        System.out.println("Det er " + boeing737.getPassasjerer() + " passasjerer på flyet " + boeing737.getModell());
        */

    }
}
