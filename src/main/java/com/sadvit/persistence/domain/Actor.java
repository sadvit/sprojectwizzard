package com.sadvit.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    // TODO project

}
