package com.sadvit.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int planTime;

    @Column
    private double difficulty;

    @Column
    private Date openDate;

    @Column
    private Date acceptDate;

    @Column
    private Date closeDate;

    // TODO task category

    // TODO req

    // TODO module

    // TODO emp id

}
