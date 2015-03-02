package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.ProjectDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProjectDAO projectDAO;

    public List<User> getAll() {
        return userDAO.loadAll();
    }

    public User get(Integer id) {
        User user = userDAO.load(id);
        if (user != null) {
            user.setLogin(null);
            user.setPass(null);
            return user;
        }
        return null;
    }

    public User getAuthUser(String loing, String pass) {
        return userDAO.getAuth(loing, pass);
    }

    public void save(User user) {
        reference(user);
        userDAO.save(user);
    }

    public void update(User user) {
        reference(user);
        userDAO.update(user);
    }

    private void reference(User user) {
        if (user.getManager() != null) {
            user.getManager().setUser(user);
        }
        if (user.getEmployee() != null) {
            user.getEmployee().setUser(user);
        }
    }

    public void delete(Integer id) {
        userDAO.delete(id);
    }

    public Set<User> getAllForProject(Integer projectId) {
        HashSet<User> users = new HashSet<User>();

        for(Employee employee : projectDAO.load(projectId).getTeam().getEmployees()) {
            users.add(employee.getUser());
        }

        return users;
    }

}
