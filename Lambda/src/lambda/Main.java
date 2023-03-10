package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Superhero> apex = new ArrayList<>();
        apex.add(new Superhero("Bangalore", "Anita Williams", 35));
        apex.add(new Superhero("Lifeline", "Ajay Che", 24));
        apex.add(new Superhero("Gibraltar", "Makao Gibralter", 30));
        apex.add(new Superhero("Caustic", "Alexander Nox", 48));
        apex.add(new Superhero("Bloodhound", "Unknown"));
        apex.add(new Superhero("Mirage", "Elliott Witt", 30));
        apex.add(new Superhero("Octane", "Octavio Silva", 24));
        apex.add(new Superhero("Pathfinder", "MRVN"));
        apex.add(new Superhero("Wraith", "Renee Blasey", 32));
        apex.add(new Superhero("Crypto", "Tae Joon Park", 31));
        apex.add(new Superhero("Wattson", "Natalie Paquette", 22));
        apex.add(new Superhero("Revenant", "Unknown", 288));
        apex.add(new Superhero("Loba", "Loba Andrade", 34));
        apex.add(new Superhero("Rampart", "Ramya Parekh", 21));
        apex.add(new Superhero("Horizon", "Dr. Mary Somers", 37));
        apex.add(new Superhero("Fuse", "Walter Fitzroy", 54));
        apex.add(new Superhero("Valkyrie", "Kairi Imahara", 30));
        apex.add(new Superhero("Seer", "Obi Edolasim", 26));
        apex.add(new Superhero("Ash", "Dr. Ashleigh Reid", 121));
        apex.add(new Superhero("Mad Maggie", "Margaret Kōhere", 55));
        apex.add(new Superhero("Newcastle", "Jackson Williams", 40));
        apex.add(new Superhero("Vantage", "Xiomara Contreras", 18));

        System.out.println(apex);

        apex.sort(new Comparator<Superhero>() {
            @Override
            public int compare(Superhero superhero1, Superhero superhero2) {
                return superhero1.getAge() - superhero2.getAge();
            }
        });

        //Lambda
        //Bruker "->" for å bruke lambda expression
        //Ett argument = trenger ikke parantes
        //En linje kode = trenger ikke return
        //Ikke return = trenger ikke krøll parantes rundt koden
        apex.sort((superhero1, superhero2) -> superhero2.getAge() - superhero1.getAge());

        System.out.println("**********Noen:**********");
        printConditionally(apex, superhero -> superhero.getName().startsWith("B"));
        System.out.println("\n**********All:**********");
        printConditionally(apex, superhero -> true);
    }

    private static void printConditionally(List<Superhero> superheroList, Condition condition) {
        for (Superhero superhero : superheroList) {
            if (condition.test(superhero))
                System.out.println(superhero);
        }
    }
}

interface Condition {
    boolean test(Superhero superhero);
}
