package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.ProjectDAO;
import com.sadvit.persistence.dao.TaskDAO;
import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.domain.Task;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.domain.type.Role;
import com.sadvit.persistence.domain.type.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProjectDAO projectDAO;

    public void save(Task task) {
        if(task.getEmployee() == null)
            task.setStatus(Status.NEW);
        else
            task.setStatus(Status.IN_PROGRESS);
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
        if(task.getEmployee() != null) {
            task.setStatus(Status.IN_PROGRESS);
        }

        taskDAO.update(task);
    }

    public List<Task> getAllForProject(Integer projectId) {
        List<Task> tasks = new ArrayList<Task>();
        for(Requirement req : projectDAO.load(projectId).getRequirements()) {
            tasks.addAll(req.getTasks());
        }

        return tasks;
    }

    public void updateStatus(Integer id, String status, Integer userId) {
        Task task = taskDAO.load(id);
        User user = userDAO.load(userId);

        switch (Status.valueOf(status)) {
            case IN_PROGRESS:
                if((user.getManager() == null) && !user.getEmployee().getRole().equals(Role.ANALYST)) {
                    task.setEmployee(user.getEmployee());
                    task.setStatus(Status.valueOf(status));
                } else {
                    System.err.println("Manager can't take tasks");
                }
                break;
            //if NEW, REOPEN, DONE or AVAILABLE
            default:
                task.setEmployee(null);
                task.setStatus(Status.valueOf(status));
        }

        update(task);
    }
}
