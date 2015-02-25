package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.ProjectDAO;
import com.sadvit.persistence.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    private ProjectDAO projectDAO;

    public List<Project> getAll() {
        return projectDAO.readAll();
    }

    public void save(Project project) {
        projectDAO.create(project);
    }

}
