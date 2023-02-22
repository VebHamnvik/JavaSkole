package oblig2_TVserier;
import java.time.LocalDate;
import java.util.ArrayList;

//Oppgave 2.1 og 2.3
abstract class Produksjon {
    private String title;
    protected int spilletid;
    private LocalDate utgivelse;
    private String beskrivelse;
    private Person regissor;
    private ArrayList<Rolle> roller;

    public Produksjon(String title, int spilletid, LocalDate utgivelse, String beskrivelse) {
        this.title = title;
        this.spilletid = spilletid;
        this.utgivelse = utgivelse;
        this.beskrivelse = beskrivelse;
        this.roller = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public LocalDate getUtgivelse() {
        return utgivelse;
    }

    public void setUtgivelse(LocalDate utgivelse) {
        this.utgivelse = utgivelse;
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

    // TODO: 22.02.2023 Trenger jeg endre metodene? Er det nok å bare skrive abstract og si seg ferdig? 
    public ArrayList<Rolle> getRoller() {
        return roller;
    }

    public void leggTilRolle(Rolle enRolle) {
        roller.add(enRolle);
    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller) {
        roller.addAll(flereRoller);
    }

}
