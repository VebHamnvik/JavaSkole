package hello.model;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TVSerie implements Comparable<TVSerie>{
    private String tittel;
    private String beskrivelse;
    private ArrayList<Episoder> episoder;
    private LocalDate utgivelse;
    private double gjennomsnittligSpilletid;
    private int antallSesonger;
    private String bildeUrl;
    // TODO: 01.03.2023 private x bildeUrl; 

    //Konstruktør
    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelse, String lenke) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.episoder = new ArrayList<>();
        this.utgivelse = utgivelse;
        this.bildeUrl = lenke;

        /*
        try{
            this.bildeUrl = ImageIO.read(new URL(lenke));
        } catch(Exception e){e.printStackTrace();}
        //https://stackoverflow.com/questions/29549366/how-to-add-an-image-to-an-object-in-java
        */


        // TODO: 01.03.2023 Legge til bildeUrl i konstruktør 
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

    public void setUtgivelse(LocalDate utgivelse) {
        this.utgivelse = utgivelse;
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

    public LocalDate getUtgivelse() {
        return utgivelse;
    }


    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    //Metoder

    @Override
    public String toString() {
        return "Title: " + tittel + "\nDescription: " + beskrivelse + "\n" + episoder + "\nRelease date: " + utgivelse;
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

    //Oppgave 2.2
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


