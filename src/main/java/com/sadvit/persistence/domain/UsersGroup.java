package com.sadvit.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UsersGroup {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    // TODO дерево

}
