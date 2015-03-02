package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team extends AbstractEntity {

    @Column
    private String name;

    @JsonManagedReference("team-employee")
    @OneToMany(mappedBy="team", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // TODO check cascade
    private Set<Employee> employees;

    @JsonManagedReference("team-project")
    @OneToMany(mappedBy="team", fetch = FetchType.EAGER)
    private Set<Project> projects;

    public Team() {

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

    public boolean hasEmployees() {
        return employees != null && employees.size() > 0;
    }

    public boolean hasProjects() {
        return projects != null && projects.size() > 0;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasEmployees=" + hasEmployees() +
                ", hasProjects=" + hasProjects() +
                '}';
    }

    @Override
    public void exchange(Object object) {
        // TODO realize
    }
}
