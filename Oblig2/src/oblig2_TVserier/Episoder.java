package oblig2_TVserier;

import java.util.ArrayList;

class Episoder{
    private String title;
    private int episodeNr;
    private int sesongNr;
    private int spilletid;

    //Konstruktor 1 med spilletid
    public Episoder(String title, int episodeNr, int sesongNr, int spilletid) {
        this.title = title;
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
        this.spilletid = spilletid;
    }
    //Konstruktor 2 uten spilletid
    public Episoder(String title, int episodeNr, int sesongNr) {
        this.title = title;
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public void setSesongNr(int sesongNr) {
        this.sesongNr = sesongNr;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public int getSesongNr() {
        return sesongNr;
    }

    public int getSpilletid(){
        return spilletid;
    }

    //Metoder
    public void printInfo() {
        System.out.println("\nSeason: " + getSesongNr() + " Episode: " + getEpisodeNr() + "\nEpisode name: " + getTitle() + "\nThis episode runs for " + getSpilletid() + " minutes");
    }

    @Override
    public String toString() {
        return "Sesong" + sesongNr + " Episode" + episodeNr + " " + title + "er " + spilletid + " minutter lang";
    }


}
