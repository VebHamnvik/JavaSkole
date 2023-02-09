package oblig2_TVserier;
//Oppgave 2.4
public class Person {
    private int alder;
    private String sex;
    private String name;

    public Person(int alder, String sex, String name) {
        this.alder = alder;
        this.sex = sex;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
