package hello.model;

//Oppgave 2.5
public class Rolle {
    private String rolleFornavn;
    private String rolleEtternavn;
    private Person skuespiller;

    public Rolle() {}

    public Rolle (String rolleFornavn, String rolleEtternavn, String name) {
        this.skuespiller = new Person(name);
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }

    public String getRolleFornavn() {
        return rolleFornavn;
    }

    public void setRolleFornavn(String rolleFornavn) {
        this.rolleFornavn = rolleFornavn;
    }

    public String getRolleEtternavn() {
        return rolleEtternavn;
    }

    public void setRolleEtternavn(String rolleEtternavn) {
        this.rolleEtternavn = rolleEtternavn;
    }

    public void setSkuespiller(Person skuespiller) {
        this.skuespiller = skuespiller;
    }

    @Override
    public String toString() {
        return "'" + rolleFornavn + " " + rolleEtternavn + "'" + " by " + skuespiller;
    }
}
