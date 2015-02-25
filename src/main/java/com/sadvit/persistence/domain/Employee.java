package com.sadvit.persistence.domain;

import com.sadvit.persistence.domain.type.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    // TODO user

    // TODO team

    @Column
    private Role role;

}
