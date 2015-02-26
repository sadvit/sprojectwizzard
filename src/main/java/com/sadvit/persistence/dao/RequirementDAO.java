package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Requirement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class RequirementDAO extends AbstractDAO<Requirement> {

    @Override
    public Requirement load(Integer id) {
        return super._load(Requirement.class, id);
    }

    @Override
    public List<Requirement> loadAll() {
        return super._loadAll(Requirement.class);
    }

}
