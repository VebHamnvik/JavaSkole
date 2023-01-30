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
        System.out.println(criticalRole);
        System.out.println("\n**********Mellomrom**********");

        //Loops for å legge til episoder i listen
        for (int i = 1; i <= 20; i++) {
            //Her er tanken at for alle tall til og med 20 skal de opprettes et objekt for episodene
            //Spilletiden genereres random mellom 20 og 30 og blir "assigned" til episodene
            //Når en episode er opprettet med tilfeldig spilletid blir objektet lagt til i listen med episoder
            //Når det er gjort vil metoden for å oppdatere gjennomsnittlig spilletid kjøre
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 1, runTime);
            criticalRole.leggTilEpisode(test);
            criticalRole.oppdaterGjennomsnitt(runTime);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 2, runTime);
            criticalRole.leggTilEpisode(test);
            criticalRole.oppdaterGjennomsnitt(runTime);

        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 3, runTime);
            criticalRole.leggTilEpisode(test);
            criticalRole.oppdaterGjennomsnitt(runTime);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 4, runTime);
            criticalRole.leggTilEpisode(test);
            criticalRole.oppdaterGjennomsnitt(runTime);
        }
        for (int i = 1; i <= 20; i++) {
            double randomNumber = 20 + (int)(Math.random() * ((30 - 20) + 1));
            int runTime = (int)randomNumber;
            Episoder test = new Episoder("'EpisodeNavn'", i, 5, runTime);
            criticalRole.leggTilEpisode(test);
            criticalRole.oppdaterGjennomsnitt(runTime);
        }

        System.out.println(criticalRole);
        System.out.println("\n**********Mellomrom**********");
        //Tester om metoden klarer å bare printe ut episodene i riktig sesong
        System.out.println(criticalRole.hentEpisoderISesong(4));

        System.out.println("\n**********Mellomrom**********");






    }

}
