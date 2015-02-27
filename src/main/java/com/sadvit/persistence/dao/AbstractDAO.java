package com.sadvit.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public abstract class AbstractDAO<T> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(T object) {
        getHibernateTemplate().saveOrUpdate(object);
    }

    public void update(T object) {
        getHibernateTemplate().update(object);
    }

    public void delete(T object) {
        getHibernateTemplate().delete(object);
    }

    public abstract T load(Integer id);

    public abstract List<T> loadAll();

    protected T _load(Class<T> clazz, Integer id) {
        return getHibernateTemplate().get(clazz, id);
    }

    protected List<T> _loadAll(Class<T> clazz) {
        return getHibernateTemplate().loadAll(clazz);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

}
