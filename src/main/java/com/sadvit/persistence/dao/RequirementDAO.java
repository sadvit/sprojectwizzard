package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Requirement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class RequirementDAO extends AbstractDAO<Requirement> {

    public RequirementDAO() {
        super(Requirement.class);
    }

}
