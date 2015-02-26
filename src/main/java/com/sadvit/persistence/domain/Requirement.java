package com.sadvit.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Requirement {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double importance;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @OneToMany(mappedBy="requirement", fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public Requirement() {
    }

    public Requirement(String name, String description, double importance, Project project, Set<Task> tasks) {

        this.name = name;
        this.description = description;
        this.importance = importance;
        this.project = project;
        this.tasks = tasks;
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
}
