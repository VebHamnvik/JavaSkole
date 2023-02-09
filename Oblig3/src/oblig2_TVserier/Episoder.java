package oblig2_TVserier;
import java.time.LocalDate;

class Episoder extends Produksjon{
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
    //(Oppgave 2.3)
    @Override
    public String toString() {
        return "Sesong" + sesongNr + " Episode" + episodeNr + " " + getTitle() + "er " + getSpilletid() + " minutter lang";
    }
}
