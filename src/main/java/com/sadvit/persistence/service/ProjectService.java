package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.ProjectDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Project> getAllForId(Integer id) {
        User user = userDAO.load(id);
        Integer uId;
        if (user.getEmployee() != null) {
             uId = user.getEmployee().getId();
            projectDAO.getAllForEmployee(uId);
        } else {
            uId = user.getManager().getId();
            projectDAO.getAllForManager(uId);
        }
        return projectDAO.loadAll();
    }

    public Project get(Integer id) {
        return projectDAO.load(id);
    }

    public void save(Project project) {
        projectDAO.save(project);
    }

    public void update(Project project) {
        projectDAO.update(project);
    }

    public void delete(Integer id) {
        projectDAO.delete(id);
    }

}
