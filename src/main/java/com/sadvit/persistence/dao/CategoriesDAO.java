package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.ProjectsCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class CategoriesDAO extends AbstractDAO<ProjectsCategory> {

    @Override
    public ProjectsCategory read(Integer id) {
        return getHibernateTemplate().load(ProjectsCategory.class, id);
    }

    @Override
    public List<ProjectsCategory> readAll() {
        return getHibernateTemplate().loadAll(ProjectsCategory.class);
    }

}
