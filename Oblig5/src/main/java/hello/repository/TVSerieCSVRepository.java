package hello.repository;

import hello.model.Episoder;
import hello.model.Person;
import hello.model.TVSerie;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TVSerieCSVRepository implements TVSerieRepository {
    private ArrayList<TVSerie> serie;
    private LinkedHashMap<String, TVSerie> hashSerie = new LinkedHashMap<>();

    public TVSerieCSVRepository(String filsti) {
        File filnavn = new File(filsti);

        try (BufferedReader leseLinjer = new BufferedReader(new FileReader(filnavn))) {
            String tekst;

            while ((tekst = leseLinjer.readLine()) != null) {
                String[] info = tekst.split(";");

                //Leser alle dataene og lagrer de i variabler
                String tvTittel = info[0];
                String tvBeskrivelse = info[1];
                String tvUtgivelse = info[2];
                String tvBildeUrl = info[3];

                String epTittel = info[4];
                String epBeskrivelse = info[5];
                String epNummer = info[6];
                String epSesongNr = info[7];
                String epSpilletid = info[8];
                String epUtgivelse = info[9];
                String epBildeUrl = info[10];

                String regFornavn = info[11];
                String regEtternavn = info[12];
                String regFodsel = info[13];

                TVSerie tvSerie = hashSerie.get(tvTittel);

                if (tvSerie == null) {
                    //TvSerien opprettes ved å bruke variablene som argumenter
                    tvSerie = new TVSerie(tvTittel, tvBeskrivelse, LocalDate.parse(tvUtgivelse), tvBildeUrl);
                    hashSerie.put(tvTittel,tvSerie);
                }

                Episoder episode = new Episoder(epTittel, Integer.parseInt(epNummer), Integer.parseInt(epSesongNr), Integer.parseInt(epSpilletid), LocalDate.parse(epUtgivelse), epBeskrivelse, epBildeUrl);
                Person regissor = new Person(regFornavn, regEtternavn, LocalDate.parse(regFodsel));
                episode.setRegissor(regissor);

                tvSerie.leggTilEpisode(episode);

            }
        serie = new ArrayList<>(hashSerie.values());
        }

        catch (FileNotFoundException e) {
            System.out.println("\nCSV FileNotFound");
            throw new RuntimeException(e);
        }
        catch (IOException f) {
            System.out.println("\nCSV IOException");
            throw  new RuntimeException(f);
        }
        finally {
            skriveCSV("CSVtest.csv", serie);
        }
    }




    public void skriveCSV(String filsti, ArrayList<TVSerie> tvSerier) {
        String splitter = ";";
        try (BufferedWriter csvInfo = new BufferedWriter(new FileWriter(filsti))) {
            for (TVSerie tvSerie : tvSerier) {
                for (Episoder episode : tvSerie.getEpisoder()) {
                    csvInfo.write(tvSerie.getTittel()+splitter+tvSerie.getBeskrivelse()+splitter+tvSerie.getUtgivelsesdato()+
                            tvSerie.getBildeUrl()+splitter+episode.getTittel()+splitter+episode.getBeskrivelse()+splitter+
                            episode.getEpisodeNummer()+splitter+episode.getSesongNummer()+splitter+episode.getSpilletid()+
                            splitter+episode.getUtgivelsesdato()+splitter+episode.getBildeUrl()+splitter+ episode.getRegissor().getFornavn()+
                            splitter+episode.getRegissor().getEtternavn()+splitter+episode.getRegissor().getFodselsDato());
                }
            }}
        catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

    @Override
    public ArrayList<TVSerie> getAlleSerier() {
        return serie;
    }

    @Override
    public TVSerie getEnSerie(String name) {
        for (TVSerie tvSerie : serie) {
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
        for (TVSerie tvserie : serie) {
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
        for (TVSerie tvserie : serie) {
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
