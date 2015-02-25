package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ProjectDAO extends AbstractDAO<Project> {

    @Override
    public Project read(Integer id) {
        return getHibernateTemplate().load(Project.class, id);
    }

    @Override
    public List<Project> readAll() {
        return getHibernateTemplate().loadAll(Project.class);
    }

}
