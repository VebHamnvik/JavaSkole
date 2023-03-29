package hello.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hello.model.Episoder;
import hello.model.TVSerie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

//2.1
public class TVSerieJSONRepository implements TVSerieRepository{
    private ArrayList<TVSerie> serier;

    //Konstruktør
    public TVSerieJSONRepository(String filsti){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFil = new File(filsti);

        try {
            objectMapper.registerModule(new JavaTimeModule());
            TVSerie[] jsonSerie = objectMapper.readValue(jsonFil, TVSerie[].class);
            //Leser informasjonen fra json filen og lager nye TvSerie objekter basert på den informasjonen
            serier = new ArrayList<>(Arrays.asList(jsonSerie));
        }
        catch (IOException feil) {
            System.out.println(feil);
            System.out.println("\nJson Konstruktør");
        }

        finally {
            skriveJson(serier, "JsonTestFil.json");
        }

    }

    //Skrive til JSON
    public void skriveJson (ArrayList<TVSerie> serie, String filsti) {
        Thread filskriver = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                File filnavn = new File(filsti);

                try {
                    //writeWith.... gir fin formatering og linjeskift
                    //Skriver hele listen med TvSerier til JSON i stedet for å bare skrive hvis det har vært noen endringer
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(filnavn, serie);
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("\nJson skriver");
                }
            }
        });
        System.out.println("Tråden som skriver til fil: " + filskriver.getName());
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

    //2.3
    @Override
    public void lagOgLeggTilEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL) {
        TVSerie riktigSerie = getEnSerie(tvSerieNavn);
        riktigSerie.lagOgLeggTilEpisode(episodeTittel,episodeNr,sesongNr, spilletid, utgivelse, beskrivelse, bildeURL);

        skriveJson(serier, "JsonTestFil.json");
    }

    @Override
    public void oppdaterEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL) {
        TVSerie riktigSerie = getEnSerie(tvSerieNavn);
        for (Episoder episoder : riktigSerie.getEpisoder()) {
            if (episoder.getSesongNummer() == sesongNr && episoder.getEpisodeNummer() == episodeNr) {
                episoder.oppdatereEpisode(episodeTittel, sesongNr, episodeNr, spilletid, beskrivelse, utgivelse, bildeURL);
            }
        }
        skriveJson(serier, "JsonTestFil.json");
    }

    @Override
    public void slettEpisode(String tvSerieNavn, int sesongNr, int episodeNr) {
        TVSerie riktigSerie = getEnSerie(tvSerieNavn);

        riktigSerie.slettEpisode(sesongNr, episodeNr);

        skriveJson(serier, "JsonTestFil.json");

    }
}
