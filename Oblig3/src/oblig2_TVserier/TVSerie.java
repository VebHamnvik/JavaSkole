package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    //Oppgave 2.7 og Bonus 1
    public ArrayList<Rolle> hentRolleBesetning() {
        ArrayList<Rolle> rolleBesetning = new ArrayList<>();
        //Bonus - Lager et tomt set fordi det ikke tillater duplikater
        Set <Rolle> ikkeDuplikater = new HashSet<>();
        //Lager en ny tom liste
        for (Episoder episoder : episoder) {
            ikkeDuplikater.addAll(episoder.getRoller());
            //Looper gjennom alle episodene og legger til alle unike roller inn i settet
            //Looper gjennom alle episodene i Tvserien og tar ut rollene i de og legger de til i den nye tomme listen
        }
        //Legger hele settet inn i den tomme listen og returnere den
        rolleBesetning.addAll(ikkeDuplikater);
        return rolleBesetning;
    }

    //Bonus 2
    public HashMap<Rolle,Integer> countEpisodes() {
        //Hashmap er litt som dictionary fra Python. Nøkkel:verdi par, der alle nøklene er unike
        HashMap<Rolle, Integer> rolleBesetning = new HashMap<>();
        //Lager et HashMap som holder på rollen og et tall som representerer antallet episoder den rollen spiller i
        for (Episoder enEpisode: episoder) {
            //Looper gjennom alle episodene i TVSerien
            for (Rolle enRolle : enEpisode.getRoller()) {
                //Looper gjennom alle rollene som er i den episoden
                if (rolleBesetning.containsKey(enRolle)) {
                    //containsKeys er en metode for å sjekke om nøkkelen er i mapet eller ikke.
                    //Hvis den nøkkelen finnes i mapet, så henter den ut den interger verdien som er satt og endrer den
                    Integer antallEpisoder = rolleBesetning.get(enRolle);
                    //Henter ut verdien til enRolle og lagrer det i antallEpisoder
                    rolleBesetning.replace(enRolle, ++antallEpisoder);
                    //Erstatter verdien med det som var fra før pluss 1
                }
                else {
                    // Hvis rollen ikke er i mapet fra før, legges den til og setter antallet episoder spilt til 1
                    rolleBesetning.put(enRolle, 1);
                }
            }}
        return rolleBesetning;
        //Fikk hjelp av DjonRussell
        //https://www.w3schools.com/java/java_hashmap.asp
        //https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/
        //https://stackoverflow.com/questions/8923273/how-can-i-have-a-hashmap-with-unique-keys-in-java

    }


}


