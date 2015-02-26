package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class TaskDAO extends AbstractDAO<Task> {

    @Override
    public Task load(Integer id) {
        return super._load(Task.class, id);
    }

    @Override
    public List<Task> loadAll() {
        return super._loadAll(Task.class);
    }

}
