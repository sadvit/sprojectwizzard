package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.EmployeeDAO;
import com.sadvit.persistence.dao.ManagerDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ManagerDAO managerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

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

    @Transactional(readOnly = false)
    public void delete(Integer id) {
        User user = userDAO.load(id);
        if (user != null)
            userDAO.delete(user);
    }

}
