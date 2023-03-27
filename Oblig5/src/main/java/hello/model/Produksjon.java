package hello.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;

//Oppgave 2.1
abstract class Produksjon {
    private String tittel;
    protected int spilletid;
    private LocalDate utgivelsesdato;
    private String beskrivelse;
    private Person regissor;

    @JsonProperty ("rolleListe")
    private ArrayList<Rolle> roller;
    private String bildeUrl;

    public Produksjon() {}

    public Produksjon(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse, String lenke) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.beskrivelse = beskrivelse;
        this.roller = new ArrayList<>();
        this.bildeUrl = lenke;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public ArrayList<Rolle> getRoller() {
        return roller;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    public void setRoller(ArrayList<Rolle> roller) {
        this.roller = roller;
    }

    public void setBildeUrl(String bildeUrl) {
        this.bildeUrl = bildeUrl;
    }

    public void leggTilRolle(Rolle enRolle) {
        roller.add(enRolle);
    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller) {
        roller.addAll(flereRoller);
    }

}
