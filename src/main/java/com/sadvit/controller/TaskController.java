package com.sadvit.controller;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.domain.Task;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.domain.type.Status;
import com.sadvit.persistence.service.ProjectService;
import com.sadvit.persistence.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}")
    public @ResponseBody List<Task> getAllForProject(@PathVariable("projectId") Integer id) {
        return taskService.getAllForProject(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Task getTask(@PathVariable("id") Integer id) {
        return taskService.load(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/requirement")
    public @ResponseBody Requirement getTaskRequirement(@PathVariable("id") Integer id) {
        return taskService.load(id).getRequirement();
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/status")
    public @ResponseBody void updateTaskStatus(@PathVariable("id") Integer id, @RequestBody String status) {
        Task task = taskService.load(id);
        task.setStatus(Status.valueOf(status));

        taskService.update(task);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/employee")
    public @ResponseBody Employee getTaskEmployee(@PathVariable("id") Integer id) {
        return taskService.load(id).getEmployee();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/user")
    public @ResponseBody User getTaskUser(@PathVariable("id") Integer id) {
        return taskService.load(id).getEmployee().getUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postTask(@RequestBody Task task) {
        taskService.save(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteTask(@PathVariable("id") Integer id) {
        taskService.delete(id);
    }
}
