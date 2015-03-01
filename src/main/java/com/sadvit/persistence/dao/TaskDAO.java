package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class TaskDAO extends AbstractDAO<Task> {

    public TaskDAO() {
        super(Task.class);
    }

}
