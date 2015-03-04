package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.*;
import com.sadvit.persistence.domain.Manager;
import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.Team;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private ManagerDAO managerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private UserDAO userDAO;

    // TODO gеределать под LazyInitialization
    public Set<Project> getAllForId(Integer id) {
        User user = userDAO.load(id);
        Integer uId;
        if (user.getEmployee() != null) {
             uId = user.getEmployee().getId();
            return employeeDAO.load(uId).getTeam().getProjects();
        } else {
            uId = user.getManager().getId();
            return managerDAO.load(uId).getProjects();
        }
    }

    public Project get(Integer id) {
        return projectDAO.load(id);
    }

    public void save(Project project) {
        Team team = teamDAO.load(project.getTeam().getId());
        Manager manager = managerDAO.load(project.getManager().getId());
        team.addProject(project);
        manager.addProject(project);
        projectDAO.save(project);
    }

    public void update(Project project) {
        projectDAO.update(project);
    }

    public void delete(Integer id) {
        projectDAO.delete(id);
    }

    public List<Project> getAll() {
        return projectDAO.loadAll();
    }

}
