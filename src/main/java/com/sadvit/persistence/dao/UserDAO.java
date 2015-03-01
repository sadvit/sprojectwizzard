package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.domain.type.Role;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDAO extends AbstractDAO<User> {

    @SuppressWarnings("unchecked")
    public User getAuth(String login, String pass) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("pass", pass));
        List<User> users = (List<User>) getHibernateTemplate().findByCriteria(criteria);
        return (users != null && users.size() > 0) ? users.get(0) : null;
    }

    public UserDAO() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> findNotBusyUsers(Role role) {
        return (List<User>) getHibernateTemplate().findByCriteria(notBusyEmployees(role));
    }

    /**
     * Список работников без команды указанной специальности
     */
    private DetachedCriteria notBusyEmployees(Role role) {
        return DetachedCriteria.forClass(User.class)
                .createCriteria("employee")
                    .add(Restrictions.isNull("team"))
                    .add(Restrictions.eq("role", role));
    }

}
