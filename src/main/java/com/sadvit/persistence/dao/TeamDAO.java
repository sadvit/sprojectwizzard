package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class TeamDAO extends AbstractDAO<Task> {

    @Override
    public Task read(Integer id) {
        return getHibernateTemplate().load(Task.class, id);
    }

    @Override
    public List<Task> readAll() {
        return getHibernateTemplate().loadAll(Task.class);
    }

}
