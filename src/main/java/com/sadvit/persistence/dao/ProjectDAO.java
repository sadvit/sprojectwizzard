package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ProjectDAO extends AbstractDAO<Project> {

    @Override
    public Project load(Integer id) {
        return super._load(Project.class, id);
    }

    @Override
    public List<Project> loadAll() {
        return super._loadAll(Project.class);
    }

}
