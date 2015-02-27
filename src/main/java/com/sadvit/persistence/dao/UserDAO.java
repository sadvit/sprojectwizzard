package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDAO extends AbstractDAO<User> {

    @Override
    public User load(Integer id) {
        return super._load(User.class, id);
    }

    @Override
    public List<User> loadAll() {
        return super._loadAll(User.class);
    }

    @SuppressWarnings("unchecked")
    public User getAuth(String login, String pass) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("pass", pass));
        List<User> users = (List<User>) getHibernateTemplate().findByCriteria(criteria);
        return (users != null && users.size() > 0) ? users.get(0) : null;
    }

}
