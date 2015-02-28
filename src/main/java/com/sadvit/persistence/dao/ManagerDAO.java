package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Manager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ManagerDAO extends AbstractDAO<Manager> {

    @Override
    public Manager load(Integer id) {
        return super._load(Manager.class, id);
    }

    @Override
    public List<Manager> loadAll() {
        return super._loadAll(Manager.class);
    }

}