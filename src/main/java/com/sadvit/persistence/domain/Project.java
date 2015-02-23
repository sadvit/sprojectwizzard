package com.sadvit.persistence.domain;


public class Project {

    private int id;

    private String name;

    private Manager manager;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Project(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }
}
