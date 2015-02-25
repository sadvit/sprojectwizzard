package com.sadvit.persistence.domain;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    // TODO categoru

    // TODO manager

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

}
