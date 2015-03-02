package com.sadvit.controller;

import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.domain.Task;
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

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postTask(@RequestBody Task task) {
        taskService.save(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteTask(@PathVariable("id") Integer id) {
        taskService.delete(id);
    }
}
