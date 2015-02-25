package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDAO extends AbstractDAO<User> {

    @Override
    public User read(Integer id) {
        return getHibernateTemplate().load(User.class, id);
    }

    @Override
    public List<User> readAll() {
        return getHibernateTemplate().loadAll(User.class);
    }

}
