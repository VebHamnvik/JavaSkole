package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSerie {
    private String name;
    private String beskrivelse;
    //private Episoder episoder;
    private ArrayList<Episoder> episoder = new ArrayList<>();
    private LocalDate utgivelse;
    private double gjennomsnittligSpilletid;

    //Konstruktør
    public TVSerie(String name, String beskrivelse, LocalDate utgivelse) {
        this.name = name;
        this.beskrivelse = beskrivelse;
        //this.episoder = episoder;
        this.utgivelse = utgivelse;
    }

    //Set
    public void setName(String name) {
        this.name = name;
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


    //Get
    public String getName() {
        return name;
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

    //Metoder
    @Override
    public String toString() {
        return "Title: " + name + "\nDescription: " + beskrivelse + "\n" + episoder + "\nRelease date: " + utgivelse;
    }

    public void leggTilEpisode(Episoder episoder) {
        this.episoder.add(episoder);
    }

    public ArrayList<Episoder> hentEpisoderISesong(int sesong) {
        ArrayList <Episoder> riktigSesong = new ArrayList<>();
        for (int v = 0; v < episoder.size(); v++) {
            if (sesong == episoder.get(v).getSesongNr()) {
                riktigSesong.add(episoder.get(v));
            }
        }
        return riktigSesong;
    }

    // TODO: 30.01.2023 Fiks denne
    public double oppdaterGjennomsnitt(int spilletid) {
        double gjennomsnitt = spilletid;
        for (Episoder episoder : episoder) {
            int spilletid2 = episoder.getSpilletid();
            gjennomsnitt += spilletid2;
        }
        gjennomsnittligSpilletid = gjennomsnitt/episoder.size();
        return gjennomsnittligSpilletid;
    }

}


