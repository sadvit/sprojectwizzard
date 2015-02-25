package com.sadvit.persistence.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name="requirements")
    private Project project;

    @OneToMany(mappedBy="requirement")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Task> tasks; // список задач для его реализации

    public Requirement() {
    }

    public Requirement(String name, String description, double importance, Project project, List<Task> tasks) {

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", importance=" + importance +
                ", project=" + project +
                ", tasks=" + tasks +
                '}';
    }
}
