package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;

class Episoder extends Produksjon implements Comparable<Episoder>{
    private int episodeNr;
    private int sesongNr;


    public Episoder(String title, int episodeNr, int sesongNr, int spilletid, LocalDate utgivelse, String beskrivelse) {
        super(title, spilletid, utgivelse, beskrivelse);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public void setSesongNr(int sesongNr) {
        this.sesongNr = sesongNr;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public int getSesongNr() {
        return sesongNr;
    }


    //Metoder
    @Override
    public String toString() {
        return "Sesong" + sesongNr + " Episode" + episodeNr + " " + getTitle() + "er " + getSpilletid() + " minutter lang";
    }

    // TODO: 22.02.2023 Trenger jeg disse? 
    @Override
    public void leggTilRolle(Rolle enRolle) {
        super.leggTilRolle(enRolle);
    }

    @Override
    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller) {
        super.leggTilMangeRoller(flereRoller);
    }

    @Override
    public int compareTo(Episoder o) {
        if (this.spilletid > o.getSpilletid()) {
            return 1;
        } else if (this.spilletid < o.getSpilletid()) {
            return -1;
        }
        else {
            return 0;
        }


    }
}
