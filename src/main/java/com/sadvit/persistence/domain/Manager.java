package com.sadvit.persistence.domain;

public class Manager {

    private int id;

    private String firstName;

    private String secondName;

    public Manager(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
