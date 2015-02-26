package com.sadvit.persistence.domain;

import com.sadvit.persistence.domain.type.Role;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
    private Set<Task> taskList;

    public Employee(Role role, User user, Team team, Set<Task> tasks) {
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

    public Set<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(Set<Task> taskList) {
        this.taskList = taskList;
    }

    public boolean hasTaskList() {
        return taskList != null && taskList.size() > 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", role=" + role +
                ", user=" + user +
                ", team=" + team +
                ", hasTaskList=" + hasTaskList() +
                '}';
    }
}
