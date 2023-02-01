package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSerie {
    private String name;
    private String beskrivelse;
    private ArrayList<Episoder> episoder;
    private LocalDate utgivelse;
    private double gjennomsnittligSpilletid;
    private int antallSesonger;

    //Konstruktør
    public TVSerie(String name, String beskrivelse, LocalDate utgivelse) {
        this.name = name;
        this.beskrivelse = beskrivelse;
        this.episoder = new ArrayList<>();
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

    //(Oppgave 2.5)
    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    //Metoder
    //(Oppgave 2.3)
    @Override
    public String toString() {
        return "Title: " + name + "\nDescription: " + beskrivelse + "\n" + episoder + "\nRelease date: " + utgivelse;
    }

    //(Oppgave 2.1 og 2.7)
    public void leggTilEpisode(Episoder episoder) {
        int sesong = episoder.getSesongNr();
        int sjekk = antallSesonger + 1;
        int spilletid = episoder.getSpilletid();
        if (sjekk >= sesong){
            this.episoder.add(episoder);
            this.antallSesonger = sesong;
            oppdaterGjennomsnitt(spilletid);
        }
        else {
            System.out.println("ERROR! Du kan ikke legge til denne episoden");
        }
    }

    //(Oppgave 2.4)
    public ArrayList<Episoder> hentEpisoderISesong(int sesong) {
        ArrayList <Episoder> riktigSesong = new ArrayList<>();
        for (int v = 0; v < episoder.size(); v++) {
            if (sesong == episoder.get(v).getSesongNr()) {
                riktigSesong.add(episoder.get(v));
            }
        }
        return riktigSesong;
    }

    //(Oppgave 2.5)
    private double oppdaterGjennomsnitt(int spilletid) {
        double gjennomsnitt = spilletid;
        for (Episoder episoder : episoder) {
            int spilletid2 = episoder.getSpilletid();
            gjennomsnitt += spilletid2;
        }
        gjennomsnittligSpilletid = gjennomsnitt/episoder.size();
        return gjennomsnittligSpilletid;
    }

}


