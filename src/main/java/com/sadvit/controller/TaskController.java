package com.sadvit.controller;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.domain.Task;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

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
    public @ResponseBody void updateTaskStatus(@PathVariable("id") Integer id, @RequestBody String status, @CookieValue(value = "id") Integer userId) {
        taskService.updateStatus(id, status, userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/employee")
    public @ResponseBody Employee getTaskEmployee(@PathVariable("id") Integer id) {
        return taskService.load(id).getEmployee();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/user")
    public @ResponseBody User getTaskUser(@PathVariable("id") Integer id) {
        Task task = taskService.load(id);
        if(task.getEmployee() != null) {
            return task.getEmployee().getUser();
        } else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postTask(@RequestBody Task task) {
        taskService.save(task);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void putTask(@RequestBody Task task) {
        taskService.update(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteTask(@PathVariable("id") Integer id) {
        taskService.delete(id);
    }
}
