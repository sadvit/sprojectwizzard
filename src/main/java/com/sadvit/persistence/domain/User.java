package com.sadvit.persistence.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class User extends AbstractEntity {

    @Column
    private String login;

    @Column
    private String pass;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column
    private String email;

    @JsonManagedReference("user-employee")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    @JsonManagedReference("user-manager")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Manager manager;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", employee=" + employee +
                ", manager=" + manager +
                '}';
    }

    @Override
    public void exchange(Object object) {
        if (object instanceof User) {
            User exchanged = (User) object;
            login = exchanged.getLogin();
            pass = exchanged.getPass();
            firstName = exchanged.getFirstName();
            middleName = exchanged.getMiddleName();
            lastName = exchanged.getLastName();
            email = exchanged.getEmail();
            employee = exchanged.getEmployee(); // TODO check
            manager = exchanged.getManager(); // TODO check
        }
    }
}
