package hello.repository;

import hello.model.Episoder;
import hello.model.TVSerie;

import java.util.ArrayList;

//Oppgave 2.5
public interface TVSerieRepository{
    //Definerer metodene
    ArrayList<TVSerie> getAlleSerier();

    TVSerie getEnSerie(String name);

    ArrayList<Episoder> getAlleEpisoderSesong(String tvSerieNavn, int sesongNr);

    Episoder getEnEpisode(String tvSerieNavn, int sesongNr, int episodeNr);
}
