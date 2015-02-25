package com.sadvit.persistence.domain;

import com.sadvit.persistence.domain.type.Role;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Role role;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(name="employees")
    private Team team;

    @OneToMany(mappedBy="employee")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Task> taskList; // список задач работника

    public Employee(Role role, User user, Team team, List<Task> tasks) {
        this.role = role;
        this.user = user;
        this.team = team;
        this.taskList = tasks;
    }

    public Employee() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", role=" + role +
                ", user=" + user +
                ", team=" + team +
                ", taskList=" + taskList +
                '}';
    }
}