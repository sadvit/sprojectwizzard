package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Manager extends AbstractEntity {

    @JsonIgnore
    @OneToMany(mappedBy= "manager", fetch = FetchType.EAGER)
    private Set<Project> projects;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Manager(Set<Project> projects, User user) {
        this.projects = projects;
        this.user = user;
    }

    public Manager() {

    }

    public boolean hasProjects() {
        return projects != null && projects.size() > 0;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", hasProjects=" + hasProjects() +
                ", user=" + user +
                '}';
    }

    @Override
    public void exchange(Object object) {
        // TODO realize
    }
}
