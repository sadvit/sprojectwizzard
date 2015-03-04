package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Manager;
import com.sadvit.persistence.domain.Project;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ProjectDAO extends AbstractDAO<Project> {

    public ProjectDAO() {
        super(Project.class);
    }

    /**
     * @param employeeId идентификатор работника
     * @return список его проектов
     */
    @SuppressWarnings("unchecked")
    public List<Project> getAllForEmployee(Integer employeeId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class)
                .add(Restrictions.eq("id", employeeId))
                .createCriteria("team")
                .createCriteria("projects");
        List<Project> projects = (List<Project>) getHibernateTemplate().findByCriteria(criteria);
        System.out.println("EMPLOYEE PROJECTS: " + projects);
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Project> getAllForManager(Integer managerId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class)
                .add(Restrictions.eq("id", managerId))
                .createCriteria("projects");
        List<Project> projects = (List<Project>) getHibernateTemplate().findByCriteria(criteria);
        System.out.println("MANAGER PROJECTS: " + projects);
        return null;
    }

}
