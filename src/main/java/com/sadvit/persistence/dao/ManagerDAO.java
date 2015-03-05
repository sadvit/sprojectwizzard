package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Manager;
import com.sadvit.persistence.domain.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional(readOnly = false)
public class ManagerDAO extends AbstractDAO<Manager> {

    public ManagerDAO() {
        super(Manager.class);
    }

    public Set<Project> getProjects(Integer id) {
        Manager manager = load(id);
        if (manager != null) {
            return manager.getProjects();
        }
        return null;
    }

}