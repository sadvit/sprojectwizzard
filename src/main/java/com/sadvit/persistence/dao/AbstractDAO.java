package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public abstract class AbstractDAO<T extends AbstractEntity> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(T object) {
        getHibernateTemplate().save(object);
    }

    /**
     * Метод получает сторонний обьект. Забирает его Id, получает из бд его оригинал.
     * Устанавливает оригинальному обьекту из БД поля стороннего и обновляет его.
     * @param object сторонний обьект
     */
    public void update(T object) {
        if (object != null && object.getId() != null && object.getId() != 0) {
            T storeable = load(object.getId());
            storeable.exchange(object);
            getHibernateTemplate().update(storeable);
        }
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
