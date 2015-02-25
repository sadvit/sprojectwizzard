package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Requirement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class RequirementDAO extends AbstractDAO<Requirement> {

    @Override
    public Requirement read(Integer id) {
        return getHibernateTemplate().load(Requirement.class, id);
    }

    @Override
    public List<Requirement> readAll() {
        return getHibernateTemplate().loadAll(Requirement.class);
    }

}
