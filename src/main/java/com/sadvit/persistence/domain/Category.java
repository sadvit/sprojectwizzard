package com.sadvit.persistence.domain;


public class Category {

    private int id;

    private String name;

    private Category parent;

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
