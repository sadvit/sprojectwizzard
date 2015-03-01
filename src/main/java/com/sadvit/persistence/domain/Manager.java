package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Manager {

    @GenericGenerator(
            name = "generator",
            strategy = "foreign",
            parameters = @Parameter(
                    name = "property",
                    value = "user"
            )
    )
    @Id
    @GeneratedValue(generator = "generator")
    private Integer id;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy= "manager", fetch = FetchType.EAGER)
    private Set<Project> projects;

    //----------------------------------------------------------

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

    public boolean hasUser() {
        return user != null;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", hasProjects=" + hasProjects() +
                ", hasUser=" + hasUser() +
                '}';
    }

    //@Override
    public void exchange(Object object) {
        // TODO realize
    }
}
