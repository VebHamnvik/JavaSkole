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


    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    //Metoder

    @Override
    public String toString() {
        return "Title: " + name + "\nDescription: " + beskrivelse + "\n" + episoder + "\nRelease date: " + utgivelse;
    }


    public void leggTilEpisode(Episoder episoder) {
        int sesong = episoder.getSesongNr();
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
            if (sesong == episoder.get(v).getSesongNr()) {
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

    //Oppgave 2.7
    public ArrayList<Rolle> hentRolleBesetning() {
        ArrayList<Rolle> rolleBesetning = new ArrayList<>();
        //Lager en ny tom liste
        for (Episoder episoder : episoder) {
            rolleBesetning.addAll(episoder.getRoller());
            //Looper gjennom alle episodene i Tvserien og tar ut rollene i de og legger de til i den nye tomme listen
        }
        return rolleBesetning;
    }

}


