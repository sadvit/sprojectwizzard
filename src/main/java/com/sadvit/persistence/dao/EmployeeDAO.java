package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional(readOnly = false)
public class EmployeeDAO extends AbstractDAO<Employee> {

    public EmployeeDAO() {
        super(Employee.class);
    }

    /**
     * @param id идентификатор сотрудника
     */
    public Set<Project> getProjects(Integer id) {
        Employee employee = load(id);
        if (employee != null) {
            Team team = employee.getTeam();
            if (team != null) {
                return team.getProjects();
            }
        }
        return null;
    }

}
