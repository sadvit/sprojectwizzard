package com.sadvit.persistence.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public abstract class AbstractDAO<T> {

    private static Logger log = Logger.getLogger(AbstractDAO.class.getSimpleName());

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Class<T> clazz;

    public Integer save(T object) {
        log.info("SAVE: " + object.toString());
        return (Integer) getHibernateTemplate().save(object);
    }

    public void update(T object) {
        log.info("UPDATE: " + object.toString());
        getHibernateTemplate().update(object);
    }

    public void delete(T object) {
        log.info("DELETE: " + object.toString());
        getHibernateTemplate().delete(object);
    }

    public void delete(Integer id) {
        T object = getHibernateTemplate().load(clazz, id);
        log.info("DELETE: " + object);
        getHibernateTemplate().delete(object);
    }

    public T load(Integer id) {
        T object = getHibernateTemplate().get(clazz, id);
        log.info("LOAD: [CLASS: " + clazz.getSimpleName() + "] [ID: " + id + "] RESULT: " + (object != null ? object.toString() : "NULL"));
        return object;
    }

    public List<T> loadAll() {
        log.info("LOAD ALL: [CLASS: " + clazz.getSimpleName() + "]");
        return getHibernateTemplate().loadAll(clazz);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

}
