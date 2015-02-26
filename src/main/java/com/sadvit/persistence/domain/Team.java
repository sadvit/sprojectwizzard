package com.sadvit.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy="team", fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    private Set<Employee> employees;

    @OneToMany(mappedBy="team", fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    private Set<Project> projects;

    public Team(String name, Set<Employee> employees, Set<Project> projects) {
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
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
