package com.sadvit.persistence.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sadvit.persistence.domain.type.Role;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @JsonProperty // TODO remove
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

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonBackReference("user-employee")
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @JsonBackReference("team-employee")
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @JsonManagedReference("employee-task")
    @OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public Employee(Role role, User user, Team team, Set<Task> tasks) {
        this.role = role;
        this.user = user;
        this.team = team;
        this.tasks = tasks;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean hasTaskList() {
        return tasks != null && tasks.size() > 0;
    }

    public boolean hasUser() {
        return user != null;
    }

    public boolean hasTeam() {
        return team != null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", role=" + role +
                ", hasUser=" + hasUser() +
                ", hasTeam=" + hasTeam() +
                ", hasTaskList=" + hasTaskList() +
                '}';
    }

    //@Override
    public void exchange(Object object) {
        if (object instanceof Employee) {
            Employee exchanged = (Employee) object;
            role = exchanged.getRole();
            user = exchanged.getUser();
            team = exchanged.getTeam();
            tasks = exchanged.getTasks();
        }
    }

}
