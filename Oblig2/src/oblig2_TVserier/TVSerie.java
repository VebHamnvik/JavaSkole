package oblig2_TVserier;
import java.time.LocalDate;

public class TVSerie {
    private String name;
    private String beskrivelse;
    private int episoder;
    //Komposisjon og ikke antall episoder i serien
    //Da vil episodene peke på serien
    private LocalDate utgivelse;

    //Konstruktør
    public TVSerie(String name, String beskrivelse, int episoder, LocalDate utgivelse) {
        this.name = name;
        this.beskrivelse = beskrivelse;
        this.episoder = episoder;
        this.utgivelse = utgivelse;
    }

    //Set
    public void setName(String name) {
        this.name = name;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setEpisoder(int episoder) {
        this.episoder = episoder;
    }

    //public void setUtgivelse()

    //Get
    public String getName() {
        return name;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getEpisoder() {
        return episoder;
    }

    public LocalDate getUtgivelse() {
        return utgivelse;
    }

    //Metoder
    public void printInfo() {
        System.out.println("Title: " + getName() + "\nDescription: " + getBeskrivelse() + "\nNumber of episodes: " + getEpisoder() + "\nRelease date: " + getUtgivelse());
    }

}


