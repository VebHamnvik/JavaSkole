package hello.model;
//Oppgave 2.4
public class Person {
    private int alder;
    private String sex;
    private String fulltNavn;

    public Person(int alder, String sex, String fulltNavn) {
        this.alder = alder;
        this.sex = sex;
        this.fulltNavn = fulltNavn;
    }

    public Person(String fulltNavn) {
        this.fulltNavn = fulltNavn;
    }

    public String getFulltNavn() {
        return fulltNavn;
    }

    @Override
    public String toString() {
        return fulltNavn;
    }


}
