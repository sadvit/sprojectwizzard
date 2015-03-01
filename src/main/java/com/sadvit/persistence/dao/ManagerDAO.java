package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Manager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class ManagerDAO extends AbstractDAO<Manager> {

    public ManagerDAO() {
        super(Manager.class);
    }

}