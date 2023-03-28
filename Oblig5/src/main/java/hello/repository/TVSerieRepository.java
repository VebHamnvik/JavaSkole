package hello.repository;

import hello.model.Episoder;
import hello.model.Person;
import hello.model.TVSerie;

import java.time.LocalDate;
import java.util.ArrayList;


public interface TVSerieRepository{
    //Definerer metodene
    ArrayList<TVSerie> getAlleSerier();

    TVSerie getEnSerie(String name);

    ArrayList<Episoder> getAlleEpisoderSesong(String tvSerieNavn, int sesongNr);

    Episoder getEnEpisode(String tvSerieNavn, int sesongNr, int episodeNr);

    //2.3
    void lagOgLeggTilEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL);

    void oppdaterEpisode(String tvSerieNavn, int sesongNr, int episodeNr, String episodeTittel, int spilletid, LocalDate utgivelse, String beskrivelse, String bildeURL);

    void slettEpisode(String tvSerieNavn, int sesongNr, int episodeNr);
}
