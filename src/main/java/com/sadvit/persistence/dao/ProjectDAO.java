package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class ProjectDAO extends AbstractDAO<Project> {

    public ProjectDAO() {
        super(Project.class);
    }

}
