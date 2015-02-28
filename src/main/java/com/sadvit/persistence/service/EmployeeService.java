package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.EmployeeDAO;
import com.sadvit.persistence.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

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

}
