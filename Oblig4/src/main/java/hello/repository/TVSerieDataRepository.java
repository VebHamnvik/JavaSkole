package hello.repository;

import hello.model.Episoder;
import hello.model.Person;
import hello.model.TVSerie;
import hello.repository.TVSerieRepository;

import java.time.LocalDate;
import java.util.ArrayList;

//Oppgave 2.5
public class TVSerieDataRepository implements TVSerieRepository {
    private ArrayList<TVSerie> serier;

    public TVSerieDataRepository() {
        this.serier = new ArrayList<>();

        TVSerie cloneWars = new TVSerie("Clone Wars", "En krig i rommet", LocalDate.of(2008, 10, 8));
        TVSerie lotr = new TVSerie("Ringenes Herre", "En krig i i Midgard", LocalDate.of(2022, 9, 1));
        TVSerie bandBrothers = new TVSerie("Band of Brothers", "En krig i Europa", LocalDate.of(2001, 9, 9));
        TVSerie witcher = new TVSerie("Witcher", "En krig mot monstre og mennesker", LocalDate.of(2019, 12, 19));

        Person peterJackson = new Person("Peter Jackson");
        Person jamesCameron = new Person("James Cameron");
        Person joeRusso = new Person("Joe Russo");
        Person jossWhedon = new Person("Joss Whedon");

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Clone Wars episoden");
                test.setRegissor(peterJackson);
                cloneWars.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Ringenes Herre episoden");
                test.setRegissor(jamesCameron);
                lotr.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Band of Brothers episoden");
                test.setRegissor(joeRusso);
                bandBrothers.leggTilEpisode(test);
            }
        }

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Witcher episoden");
                test.setRegissor(jossWhedon);
                witcher.leggTilEpisode(test);
            }
        }


        serier.add(cloneWars);
        serier.add(lotr);
        serier.add(bandBrothers);
        serier.add(witcher);
    }


    @Override
    public ArrayList<TVSerie> getAlleSerier() {
        return serier;
    }

    @Override
    public TVSerie getEnSerie(String name) {
        for (TVSerie tvSerie : serier) {
            if (name.equals(tvSerie.getTittel())) {
                return tvSerie;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Episoder> getAlleEpisoderSesong(String tvSerieNavn, int sesongNr) {
        ArrayList<Episoder> episoderSesong = new ArrayList<>();
        //Går gjennom alle TvSeriene og sjekker om navnet stemmer med argumentet
        for (TVSerie tvserie : serier) {
            if (tvSerieNavn.equals(tvserie.getTittel())) {
                //Går gjennom alle episodene i TvSerien og sjekker sesongnummeret opp mot argumentet
                for (Episoder episode : tvserie.getEpisoder()) {
                    if (sesongNr == episode.getSesongNummer()) {
                        //Legger til i nye listen hvis sesongnummeret stemmer
                        episoderSesong.add(episode);
                    }
                }
                return episoderSesong;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Episoder getEnEpisode(String tvSerieNavn, int sesongNr, int episodeNr) {
        for (TVSerie tvserie : serier) {
            if (tvSerieNavn.equals(tvserie.getTittel())) {
                //Går gjennom alle tvseriene og finner riktig
                for (Episoder episode : tvserie.getEpisoder()) {
                    if (sesongNr == episode.getSesongNummer()) {
                        //Går gjennom alle sesongene og finner riktig
                        for (Episoder riktigEpisode : tvserie.getEpisoder()) {
                            if (episodeNr == riktigEpisode.getEpisodeNummer()) {
                                return riktigEpisode;
                                //Går gjennom alle episodene og finner riktig
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
