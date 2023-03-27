package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TVSerie implements Comparable<TVSerie>{
    private String tittel;
    private String beskrivelse;
    private ArrayList<Episoder> episoder;
    private LocalDate utgivelsesdato;
    private double gjennomsnittligSpilletid;
    private int antallSesonger;
    private String bildeUrl;

    public TVSerie() {}

    //Konstruktør
    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato, String lenke) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.episoder = new ArrayList<>();
        this.utgivelsesdato = utgivelsesdato;
        this.bildeUrl = lenke;

    }

    //Set
    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setEpisoder(ArrayList<Episoder> episoder) {
        this.episoder = episoder;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    //Get
    public String getTittel() {
        return tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public ArrayList<Episoder> getEpisoder() {
        return episoder;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    @JsonIgnore
    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    public void setGjennomsnittligSpilletid(double gjennomsnittligSpilletid) {
        this.gjennomsnittligSpilletid = gjennomsnittligSpilletid;
    }

    public void setAntallSesonger(int antallSesonger) {
        this.antallSesonger = antallSesonger;
    }

    public void setBildeUrl(String bildeUrl) {
        this.bildeUrl = bildeUrl;
    }

    //Metoder

    @Override
    public String toString() {
        return "Title: " + tittel + "\nDescription: " + beskrivelse + "\n" + episoder + "\nRelease date: " + utgivelsesdato;
    }


    public void leggTilEpisode(Episoder episoder) {
        int sesong = episoder.getSesongNummer();
        int sjekk = antallSesonger + 1;
        if (sjekk >= sesong) {
            this.episoder.add(episoder);
            this.antallSesonger = sesong;
            oppdaterGjennomsnitt();
        } else {
            System.out.println("ERROR! Du kan ikke legge til denne episoden");
        }
    }


    public ArrayList<Episoder> hentEpisoderISesong(int sesong) {
        ArrayList<Episoder> riktigSesong = new ArrayList<>();
        for (int v = 0; v < episoder.size(); v++) {
            if (sesong == episoder.get(v).getSesongNummer()) {
                riktigSesong.add(episoder.get(v));
            }
        }
        return riktigSesong;
    }


    private double oppdaterGjennomsnitt() {
        double gjennomsnitt = 0;
        for (Episoder episoder : episoder) {
            gjennomsnitt += episoder.getSpilletid();
        }
        gjennomsnittligSpilletid = gjennomsnitt / episoder.size();
        return gjennomsnittligSpilletid;
    }

    //Oppgave
    public ArrayList<Rolle> hentRolleBesetning() {
        ArrayList<Rolle> rolleBesetning = new ArrayList<>();
        Set <Rolle> ikkeDuplikater = new HashSet<>();
        for (Episoder episoder : episoder) {
            ikkeDuplikater.addAll(episoder.getRoller());

        }
        rolleBesetning.addAll(ikkeDuplikater);
        return rolleBesetning;
    }


    public HashMap<Rolle,Integer> countEpisodes() {
        HashMap<Rolle, Integer> rolleBesetning = new HashMap<>();
        for (Episoder enEpisode: episoder) {
            for (Rolle enRolle : enEpisode.getRoller()) {
                if (rolleBesetning.containsKey(enRolle)) {
                    Integer antallEpisoder = rolleBesetning.get(enRolle);
                    rolleBesetning.replace(enRolle, ++antallEpisoder);
                }
                else {
                    rolleBesetning.put(enRolle, 1);
                }
            }}
        return rolleBesetning;
    }

    @Override
    public int compareTo(TVSerie a) {
        if (episoder.size() > a.getEpisoder().size()) {
            return 1;
        } else if (episoder.size() < a.getEpisoder().size()) {
            return -1;
        } else {
            return 0;
        }
    }


}


