package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.*;
import com.sadvit.persistence.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Project> getAll() {
        return projectDAO.loadAll();
    }

    /**
     * @param id идентификатор пользователя
     * @return все его проекты
     */
    public Set<Project> getAll(Integer id) {
        User user = userDAO.load(id);
        if (user != null) {
            Integer uId;
            if (user.getEmployee() != null) {
                uId = user.getEmployee().getId();
                if (uId != null)
                    return employeeDAO.getProjects(uId);
            }
            if (user.getManager() != null) {
                uId = user.getManager().getId();
                if (uId != null)
                    return managerDAO.getProjects(uId);
            }
        }
        return null;
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

    public Map<String, String> getContacts(Integer id) {
        User user = get(id).getManager().getUser();
        Map<String, String> contacts = new HashMap<String, String>();
        String name = user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName();
        String email = user.getEmail();
        contacts.put("name", name);
        contacts.put("email", email);
        return contacts;
    }

}
