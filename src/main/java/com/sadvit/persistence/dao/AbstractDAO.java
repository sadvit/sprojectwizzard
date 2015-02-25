package com.sadvit.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public abstract class AbstractDAO<T> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void create(T object) {
        getHibernateTemplate().save(object);
    }

    public void update(T object) {
        getHibernateTemplate().update(object);
    }

    public void delete(T object) {
        getHibernateTemplate().delete(object);
    }

    public abstract T read(Integer id);

    public abstract List<T> readAll();

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

}
