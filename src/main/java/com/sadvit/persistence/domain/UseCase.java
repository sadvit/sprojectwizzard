package com.sadvit.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UseCase {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    // TODO module

}
