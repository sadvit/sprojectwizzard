package com.sadvit.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ActorUseCaseRelation {

    @Id
    @GeneratedValue
    private int id;

    // TODO actor id

    // TODO use case id

}
