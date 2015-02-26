package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @JsonIgnore
    @OneToMany(mappedBy="project", fetch = FetchType.EAGER)
    private Set<Requirement> requirements;

    public Project(String name, String description, Team team, Set<Requirement> requirements) {
        this.name = name;
        this.description = description;
        this.team = team;
        this.requirements = requirements;
    }

    public Project() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    public boolean hasRequirements() {
        return requirements != null && requirements.size() > 0;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", team=" + team +
                ", manager=" + manager +
                ", hasRequirements=" + hasRequirements() +
                '}';
    }

}
