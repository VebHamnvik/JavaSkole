package hello.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class Person {
    private int alder;
    private String sex;
    private String fulltNavn;
    private String fornavn;
    private String etternavn;
    private LocalDate fodselsDato;

    public Person() {}

    public Person(String fornavn, String etternavn, LocalDate fodselsDato) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsDato = fodselsDato;
    }

    public Person(int alder, String sex, String fulltNavn) {
        this.alder = alder;
        this.sex = sex;
        this.fulltNavn = fulltNavn;
    }

    public Person(String fulltNavn) {
        this.fulltNavn = fulltNavn;
    }

    @JsonIgnore
    public String getFulltNavn() {
        return fulltNavn;
    }

    @JsonIgnore
    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    @JsonIgnore
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setFulltNavn(String fulltNavn) {
        this.fulltNavn = fulltNavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public void setFodselsDato(LocalDate fodselsDato) {
        this.fodselsDato = fodselsDato;
    }

    @Override
    public String toString() {
        return fulltNavn;
    }


}
