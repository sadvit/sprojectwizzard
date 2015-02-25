package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class EmployeeDAO extends AbstractDAO<Employee> {

    @Override
    public Employee read(Integer id) {
        return getHibernateTemplate().load(Employee.class, id);
    }

    @Override
    public List<Employee> readAll() {
        return getHibernateTemplate().loadAll(Employee.class);
    }

}
