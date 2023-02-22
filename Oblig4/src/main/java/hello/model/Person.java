package hello.model;
//Oppgave 2.4
public class Person {
    private int alder;
    private String sex;
    private String fulltnavn;

    public Person(int alder, String sex, String fulltnavn) {
        this.alder = alder;
        this.sex = sex;
        this.fulltnavn = fulltnavn;
    }

    public Person(String fulltnavn) {
        this.fulltnavn = fulltnavn;
    }

    @Override
    public String toString() {
        return fulltnavn;
    }


}
