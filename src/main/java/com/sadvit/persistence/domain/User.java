package com.sadvit.persistence.domain;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String pass;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column
    private String email;

    @OneToOne(mappedBy = "user")
    private Employee employee; // если пользователь - работник

    @OneToOne(mappedBy = "user")
    private Manager manager; // если пользователь - менеджер

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
/*
    public User(String login, String password, String firstName, String middleName, String lastName) {
        this.login = login;
        this.pass = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
*/

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
}
