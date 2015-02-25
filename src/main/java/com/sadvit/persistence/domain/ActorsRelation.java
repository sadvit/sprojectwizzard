package com.sadvit.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ActorsRelation {

    @Id
    @GeneratedValue
    private int id;

    // TODO parent id

    // TODO child id

}
