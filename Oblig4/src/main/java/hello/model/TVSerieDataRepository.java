package hello.model;

import java.time.LocalDate;
import java.util.ArrayList;

//Oppgave 2.5
public class TVSerieDataRepository implements TVSerieRepository{
    private ArrayList<TVSerie> serier;

    public TVSerieDataRepository() {
        this.serier = new ArrayList<>();

        TVSerie cloneWars = new TVSerie("Star Wars: Clone Wars", "En krig i rommet", LocalDate.of(2008, 10, 8));
        TVSerie lotr = new TVSerie("Lord of the Rings: The Rings of Power", "En krig i i Midgard", LocalDate.of(2022, 9, 1));
        TVSerie bandBrothers = new TVSerie("Band of Brothers", "En krig i Europa", LocalDate.of(2001, 9, 9));
        TVSerie witcher = new TVSerie("Witcher", "En krig mot monstre og mennesker", LocalDate.of(2019, 12, 19));

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'EpisodeNavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "tekst");
                cloneWars.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'EpisodeNavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "tekst");
                lotr.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'EpisodeNavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "tekst");
                bandBrothers.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'EpisodeNavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "tekst");
                witcher.leggTilEpisode(test);
            }
        }


        serier.add(cloneWars);
        serier.add(lotr);
        serier.add(bandBrothers);
        serier.add(witcher);
    }


    @Override
    public void getAlleSerier() {
        for (TVSerie tvSerie : this.serier) {
            System.out.println(tvSerie.getTittel());
        }
    }

    @Override
    public void getEnSerie(String name) {
        for (TVSerie tvSerie : serier) {
            if (name.equals(tvSerie.getTittel())) {
                System.out.println(tvSerie);
            }
        }
    }


}
