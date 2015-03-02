package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.ProjectDAO;
import com.sadvit.persistence.dao.TaskDAO;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private ProjectDAO projectDAO;

    public void save(Task task) {
        taskDAO.save(task);
    }

    public List<Task> getAll() {
        return taskDAO.loadAll();
    }

    public Task load(Integer id) {
        return taskDAO.load(id);
    }

    public void delete(Integer id) {
        taskDAO.delete(id);
    }

    public void update(Task task) {
        taskDAO.update(task);
    }

    public List<Task> getAllForProject(Integer projectId) {
        List<Task> tasks = new ArrayList<Task>();
        for(Requirement req : projectDAO.load(projectId).getRequirements()) {
            tasks.addAll(req.getTasks());
        }

        return tasks;
    }
}
