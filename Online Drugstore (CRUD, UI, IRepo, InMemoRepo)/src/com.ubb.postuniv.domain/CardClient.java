package com.ubb.postuniv.domain;

import java.time.LocalDate;

public class CardClient extends Entity {
    private String name;
    private String surname;
    private String CNP;
    private String birthDate;
    private String registrationDate;


    public CardClient(int id, String name, String surname, String CNP, String birthDate, String registrationDate) {
        setId(id);
        this.name = name;
        this.surname = surname;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public String getRegistrationDate(){
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "cardClient{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", CNP=" + CNP +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                '}';
    }
}