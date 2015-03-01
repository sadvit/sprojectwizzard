package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.EmployeeDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.domain.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private UserDAO userDAO;

    public List<Employee> getAll() {
        return employeeDAO.loadAll();
    }

    public Employee get(Integer id) {
        return employeeDAO.load(id);
    }

    public void save(Employee project) {
        employeeDAO.save(project);
    }

    public void update(Employee project) {
        employeeDAO.update(project);
    }

    public List<User> getNotBusyLeaders() {
        return userDAO.findNotBusyUsers(Role.LEADER);
    }

    public List<User> getNotBusyProgrammers() {
        return userDAO.findNotBusyUsers(Role.PROGRAMMER);
    }

    public List<User> getNotBusyAnalysts() {
        return userDAO.findNotBusyUsers(Role.ANALYST);
    }

}
