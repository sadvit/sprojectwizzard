package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Requirement extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double importance;

    @JsonBackReference("manager-requirement")
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @JsonManagedReference("requirement-task")
    @OneToMany(mappedBy="requirement", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Task> tasks;

    public Requirement() {

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

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean hasTasks() {
        return tasks != null && tasks.size() > 0;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", importance=" + importance +
                ", project=" + project +
                ", hasTasks=" + hasTasks() +
                '}';
    }

    @Override
    public void exchange(Object object) {
        // TODO realize
    }
}
