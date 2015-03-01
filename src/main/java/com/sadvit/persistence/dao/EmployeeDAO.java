package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class EmployeeDAO extends AbstractDAO<Employee> {

    public EmployeeDAO() {
        super(Employee.class);
    }

}
