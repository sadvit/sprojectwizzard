package com.sadvit.persistence.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public abstract class AbstractDAO<T> {

    private static Logger log = Logger.getLogger(AbstractDAO.class.getSimpleName());

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Integer save(T object) {
        log.info("SAVE: " + object.toString());
        return (Integer) getHibernateTemplate().save(object);
    }

    /**
     * Метод получает сторонний обьект. Забирает его Id, получает из бд его оригинал.
     * Устанавливает оригинальному обьекту из БД поля стороннего и обновляет его.
     * @param object сторонний обьект
     */
    public T update(T object) {
        getHibernateTemplate().update(object);
        /*
        if (object != null && object.getId() != null && object.getId() != 0) {
            T storeable = load(object.getId());
            storeable.exchange(object);
            log.info("UPDATE: " + storeable.toString());
            getHibernateTemplate().update(storeable);
            return storeable;
        }*/
        return object;
    }

    public void delete(T object) {
        log.info("DELETE: " + object.toString());
        getHibernateTemplate().delete(object);
    }

    public abstract T load(Integer id);

    public abstract List<T> loadAll();

    protected T _load(Class<T> clazz, Integer id) {
        T object = getHibernateTemplate().get(clazz, id);
        log.info("LOAD: [CLASS: " + clazz.getSimpleName() + "] [ID: " + id + "] RESULT: " + (object != null ? object.toString() : "NULL"));
        return object;
    }

    protected List<T> _loadAll(Class<T> clazz) {
        log.info("LOAD ALL: [CLASS: " + clazz.getSimpleName() + "]");
        return getHibernateTemplate().loadAll(clazz);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

}
