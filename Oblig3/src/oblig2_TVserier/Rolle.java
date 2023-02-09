package oblig2_TVserier;

//Oppgave 2.5
public class Rolle {
    private String rolleFornavn;
    private String rolleEtternavn;
    private Person skuespiller;

    public Rolle (String rolleFornavn, String rolleEtternavn, String name) {
        this.skuespiller = new Person(name);
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
    }

    @Override
    public String toString() {
        return "'" + rolleFornavn + " " + rolleEtternavn + "'" + " by " + skuespiller;
    }
}
