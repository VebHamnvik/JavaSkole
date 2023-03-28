package hello.repository;

import hello.model.Episoder;
import hello.model.Person;
import hello.model.TVSerie;
import hello.repository.TVSerieRepository;

import java.time.LocalDate;
import java.util.ArrayList;


public class TVSerieDataRepository implements TVSerieRepository {
    private ArrayList<TVSerie> serier;

    public TVSerieDataRepository() {
        this.serier = new ArrayList<>();

        // TODO: 01.03.2023 Legge til bildeUrl i instansieringen av objektene

        TVSerie cloneWars = new TVSerie("Clone Wars", "En krig i rommet", LocalDate.of(2008, 10, 8), "https://images.thedirect.com/media/article_full/star-wars-celebrates-the-clone-wars-official-watch-order-chronological_.jpg");
        TVSerie lotr = new TVSerie("Ringenes Herre", "En krig i i Midgard", LocalDate.of(2022, 9, 1), "https://premium.vgc.no/v2/images/34968bc5-6839-4148-9c5a-ec63e66610a9?fit=crop&format=auto&h=1157&w=2019&s=a8a19d5f68775aea9ad5e62dbd80515c59fe767d");
        TVSerie bandBrothers = new TVSerie("Band of Brothers", "En krig i Europa", LocalDate.of(2001, 9, 9), "https://m.media-amazon.com/images/M/MV5BMzFhMDQ5MTItMjllMy00YmM2LTk3NmYtY2I3MTIxMzAyNDFlXkEyXkFqcGdeQW1pYnJ5YW50._V1_.jpg");
        TVSerie witcher = new TVSerie("Witcher", "En krig mot monstre og mennesker", LocalDate.of(2019, 12, 19), "https://flxt.tmsimg.com/assets/p17580186_i_h10_ab.jpg");

        Person peterJackson = new Person("Peter Jackson");
        Person jamesCameron = new Person("James Cameron");
        Person joeRusso = new Person("Joe Russo");
        Person jossWhedon = new Person("Joss Whedon");

        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 20; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Clone Wars episoden", "https://m.media-amazon.com/images/M/MV5BNWQ2MWYyMmItMTRjMS00YWQyLThiYjEtZTI0MTI1OGMzZjJmXkEyXkFqcGdeQW1yb2Njbw@@._V1_.jpg");
                test.setRegissor(peterJackson);
                cloneWars.leggTilEpisode(test);
                //
            }
        }

        for (int j = 1; j <= 3; j++) {
            for (int i = 1; i <= 25; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Ringenes Herre episoden", "https://www.cdn.tv2.no/images/9473751.jpg?imageId=9473751&width=1060&height=597");
                test.setRegissor(jamesCameron);
                lotr.leggTilEpisode(test);
                //https://www.cdn.tv2.no/images/9473751.jpg?imageId=9473751&width=1060&height=597
            }
        }

        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 18; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Band of Brothers episoden", "https://cloudfront-eu-central-1.images.arcpublishing.com/mentormedier/W3BWILDHKNGQJJQV7PVEDNCPO4.jpg");
                test.setRegissor(joeRusso);
                bandBrothers.leggTilEpisode(test);
                //https://cloudfront-eu-central-1.images.arcpublishing.com/mentormedier/W3BWILDHKNGQJJQV7PVEDNCPO4.jpg
            }
        }

        for (int j = 1; j <= 6; j++) {
            for (int i = 1; i <= 22; i++) {
                double randomNumber = 20 + (int) (Math.random() * ((30 - 20) + 1));
                int runTime = (int) randomNumber;
                Episoder test = new Episoder("'Episodenavn'", i, j, runTime, LocalDate.of(2000, 5, 5), "Beskrivende tekst om Witcher episoden", "https://www.pcgamesn.com/wp-content/sites/pcgamesn/2019/04/netflix-witcher.jpg");
                test.setRegissor(jossWhedon);
                witcher.leggTilEpisode(test);
                //https://www.pcgamesn.com/wp-content/sites/pcgamesn/2019/04/netflix-witcher.jpg
            }
        }

        serier.add(cloneWars);
        serier.add(lotr);
        serier.add(bandBrothers);
        serier.add(witcher);

        System.out.println(cloneWars.compareTo(witcher));

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

    @Override
    public void lagOgLeggTilEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL) {

    }

    @Override
    public void oppdaterEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL) {

    }

    @Override
    public void slettEpisode(String tvSerieNavn, int sesongNr, int episodeNr) {

    }
}
