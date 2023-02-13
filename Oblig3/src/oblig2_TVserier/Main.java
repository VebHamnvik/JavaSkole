package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        //Lager et TVSerie objekt
        TVSerie criticalRole = new TVSerie("Critical Role", "En strømmet d&d serie",LocalDate.of(2015, 3, 12));

        //Kan lage og legge til episoder enkeltvis
        /*Episoder test2 = new Episoder("tittel", 2, 1, 75);
        Episoder test3 = new Episoder("tittel", 3, 1, 75);
        Episoder test4 = new Episoder("tittel", 4, 1, 75);
        criticalRole.leggTilEpisode(test2);
        criticalRole.leggTilEpisode(test3);
        criticalRole.leggTilEpisode(test4);
         */
        //Skriver ut informasjon om serien og episoden

        //Testing for å se om nye funksjonen i leggTilEpisode funker
        /* System.out.println(criticalRole);
        System.out.println("\n**********Mellomrom**********");
        Episoder test = new Episoder("Første Sesong", 1, 1, 35);
        Episoder test2 = new Episoder("Første Sesong", 1, 2, 35);
        criticalRole.leggTilEpisode(test);
        criticalRole.leggTilEpisode(test2);
        System.out.println(criticalRole);
        System.out.println(criticalRole.getAntallSesonger());
        Episoder nyTest = new Episoder("Tredje Sesong", 1, 3, 35);
        Episoder nyTest2 = new Episoder("Tredje Sesong", 1, 6, 35);
        criticalRole.leggTilEpisode(nyTest);
        criticalRole.leggTilEpisode(nyTest2);
        System.out.println(criticalRole.getAntallSesonger());*/


        //Loops for å legge til episoder i listen
        for (int i = 1; i <= 20; i++) {
            //Her er tanken at for alle tall til og med 20 skal de opprettes et objekt for episodene
            //Spilletiden genereres random mellom 20 og 30 og blir "assigned" til episodene
            //Når en episode er opprettet med tilfeldig spilletid blir objektet lagt til i listen med episoder
            //Når det er gjort vil metoden for å oppdatere gjennomsnittlig spilletid kjøre
            //(Oppgave 2.6)
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 1, runTime, LocalDate.of(2000, 5, 5), "tekst");
            criticalRole.leggTilEpisode(test);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 2, runTime, LocalDate.of(2000, 5, 5), "tekst");
            criticalRole.leggTilEpisode(test);

        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 3, runTime, LocalDate.of(2000, 5, 5), "tekst");
            criticalRole.leggTilEpisode(test);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 4, runTime, LocalDate.of(2000, 5, 5), "tekst");
            criticalRole.leggTilEpisode(test);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 5, runTime, LocalDate.of(2000, 5, 5), "tekst");
            criticalRole.leggTilEpisode(test);
        }

        System.out.println("\n**********Info om TvSerie**********");
        System.out.println(criticalRole);
        System.out.println("\nGjennomsnittlig spilletid for episodene i TvSerien er: " + criticalRole.getGjennomsnittligSpilletid() + " minutter");
        System.out.println("\n**********Hente sesong 4**********");
        //Tester om metoden klarer å bare printe ut episodene i riktig sesong
        System.out.println(criticalRole.hentEpisoderISesong(4));

        //Oppgave 2.2
        Film jaws = new Film("Jaws", 126, LocalDate.of(1976, 2, 16), "En film om en stor hai");
        Film starWars = new Film("Star Wars", 132, LocalDate.of(2007, 3, 9), "En krig om universet");
        Film gladiator = new Film("Gladiator", 117, LocalDate.of(2000, 5, 19), "En romersk general blir en gladiator");
        System.out.println("\n**********Filmtitler**********");
        System.out.println(jaws.getTitle());
        System.out.println(starWars.getTitle());
        System.out.println(gladiator.getTitle());

        //Oppgave 2.4
        System.out.println("\n**********Regissør**********");
        Person peter = new Person(61, "Male", "Peter Jackson");
        Person kate = new Person(54, "Female", "Kate Shortland");
        Episoder testRegissor = new Episoder("Funker Regissør", 14, 3, 25, LocalDate.of(2019, 5, 17), "Testing av regissør i episode");

        jaws.setRegissor(peter);
        testRegissor.setRegissor(kate);
        System.out.println(jaws.getRegissor());
        System.out.println(testRegissor.getRegissor());

        //Oppgave 2.5
        System.out.println("\n**********Roller**********");
        ArrayList<Rolle> listeMedRoller = new ArrayList<>();
        Rolle jackSparrow = new Rolle("Jack", "Sparrow", "Johnny Depp");
        Rolle kenobi = new Rolle("Obi-Won", "Kenobi", "Ewan McGregor");
        Rolle padme = new Rolle("Padme", "Amidala", "Natalie Portman");
        Rolle homer = new Rolle("Homer", "Simpson", "Dan Castellaneta");
        Rolle bart = new Rolle("Bart", "Simpson", "Nancy Cartwright");

        //Legger rollene inn i riktige filmer gjennom 1 og 1, og gjennom en liste
        jaws.leggTilRolle(jackSparrow);
        testRegissor.leggTilRolle(homer);
        listeMedRoller.add(kenobi);
        listeMedRoller.add(padme);
        starWars.leggTilMangeRoller(listeMedRoller);

        //Skriver ut rollene
        System.out.println(jaws.getRoller());
        System.out.println(starWars.getRoller());
        System.out.println(testRegissor.getRoller());

        //Oppgave 2.6
        //Sjekker at alle toString funker
        System.out.println("\n**********Info om film/episode**********");
        System.out.println(jaws);
        System.out.println("\n" + starWars);


        //Oppgave 2.7
        //Lager en ny TvSerie med 20 episoder og lager legger til 2 roller for den som blir lagt til i hver episode
        TVSerie simpson = new TVSerie("The Simpsons","Gule mennesker tuller rundt", LocalDate.of(1989, 12, 17));
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder simpsonEpisoder = new Episoder("'EpisodeNavn'", i, 1, runTime, LocalDate.of(2000, 5, 5), "tekst");
            simpson.leggTilEpisode(simpsonEpisoder);
            simpsonEpisoder.leggTilRolle(homer);
            simpsonEpisoder.leggTilRolle(bart);
        }

        System.out.println("\n**********Simpsons og rollene**********");
        System.out.println("\n" + simpson);
        System.out.println();
        System.out.println(simpson.hentRolleBesetning());

        System.out.println("\n**********Telle episoder**********");
        System.out.println(simpson.countEpisodes());




    }

}
