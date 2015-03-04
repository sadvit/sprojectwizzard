package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Project extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @JsonBackReference("team-project")
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonBackReference("manager-project")
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @JsonManagedReference("manager-requirement")
    @OneToMany(mappedBy="project", fetch = FetchType.EAGER)
    private Set<Requirement> requirements;

    public Project() {

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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

    @Override
    public void exchange(Object object) {
        // TODO realize
    }
}
