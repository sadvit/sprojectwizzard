package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.TaskDAO;
import com.sadvit.persistence.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;
    
    public void save(Task task) {
        taskDAO.save(task);
    }

    public List<Task> getAll() {
        return taskDAO.loadAll();
    }

}
