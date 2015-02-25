package com.sadvit.persistence.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy="team")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Employee> employees;

    @OneToMany(mappedBy="team")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Project> projects;

    public Team(String name, List<Employee> employees, List<Project> projects) {
        this.name = name;
        this.employees = employees;
        this.projects = projects;
    }

    public Team() {

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", projects=" + projects +
                '}';
    }
}
