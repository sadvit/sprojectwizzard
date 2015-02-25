package com.sadvit.persistence.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectsCategory {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    /**
     * Для извлечения будем юзать запрос, возвращающий все рутовые элементы, где парент - нулл.
     * Потом начиная с парента обходить все чилды и добавлять в JSON. Получится дерево.
     */
    @ManyToOne //add column definitions as needed
    private ProjectsCategory parent;      //each Domain with parent==null is a root domain, all others are subcategories

    @OneToMany //add column definitions as needed
    private List<ProjectsCategory> subcategories;

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

    public ProjectsCategory getParent() {
        return parent;
    }

    public void setParent(ProjectsCategory parent) {
        this.parent = parent;
    }

    public List<ProjectsCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<ProjectsCategory> subcategories) {
        this.subcategories = subcategories;
    }

    public ProjectsCategory() {
    }

    public ProjectsCategory(String name, ProjectsCategory parent, List<ProjectsCategory> subdomains) {
        this.name = name;
        this.parent = parent;
        this.subcategories = subdomains;
    }

}