package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.EmployeeDAO;
import com.sadvit.persistence.dao.ManagerDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Manager;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional(readOnly = false) // в классы сервисы не ставить! если нужен метод в рамках транзакции, писать над методом!
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

    @Transactional(readOnly = false)
    public void save(User user) {
        Manager manager = null;
        Employee employee = null;
        if (user.getManager() != null) {
            manager = user.getManager();
            managerDAO.save(manager);
        }
        if (user.getEmployee() != null) {
            employee = user.getEmployee();
            employeeDAO.save(employee);
        }
        user.setEmployee(employee);
        user.setManager(manager);
        userDAO.save(user);
    }

    // и этот тоже
    public void update(User user) {
        Manager manager = null;
        Employee employee = null;
        if (user.getManager() != null) {
            manager = user.getManager();
            managerDAO.update(manager);
        }
        if (user.getEmployee() != null) {
            employee = user.getEmployee();
            employeeDAO.update(employee);
        }
        user.setEmployee(employee);
        user.setManager(manager);
        userDAO.update(user);
    }

    @Transactional(readOnly = false)
    public void delete(Integer id) {
        User user = userDAO.load(id);
        if (user != null)
            userDAO.delete(user);
    }

}
