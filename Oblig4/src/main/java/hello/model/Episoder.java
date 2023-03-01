package hello.model;
import java.time.LocalDate;

public class Episoder extends Produksjon implements Comparable<Episoder>{
    private int episodeNummer;
    private int sesongNummer;


    public Episoder(String title, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelse, String beskrivelse, String lenke) {
        super(title, spilletid, utgivelse, beskrivelse, lenke);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public void setSesongNummer(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }


    //Metoder
    @Override
    public String toString() {
        return "Sesong" + sesongNummer + " Episode" + episodeNummer + " " + getTittel() + "er " + getSpilletid() + " minutter lang";
    }

    //Oppgave 2.2
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
