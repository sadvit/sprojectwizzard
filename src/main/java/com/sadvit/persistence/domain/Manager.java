package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {

    @JsonProperty  // TODO remove
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

    @JsonBackReference("user-manager")
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @JsonManagedReference("manager-project")
    @OneToMany(mappedBy= "manager", fetch = FetchType.EAGER)
    private Set<Project> projects;

    //----------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void addProject(Project project) {
        if (!hasProjects()) projects = new HashSet<Project>();
        projects.add(project);
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
