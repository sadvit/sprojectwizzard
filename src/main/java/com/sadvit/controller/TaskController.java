package com.sadvit.controller;

import com.sadvit.persistence.domain.Task;
import com.sadvit.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}")
    public @ResponseBody List<Task> getAll(@PathVariable("projectId") Long id) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        for(int i = 0; i < id; i++) {
            Task t = new Task();
            t.setId(i);
            t.setName(id + " task's name");
            t.setDescription(i + " task's description");
            tasks.add(t);
        }
        return tasks;
    }

}
