package com.sadvit.controller;

import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all_projects")
    public @ResponseBody List<Project> all_projects() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/project")
    public @ResponseBody void project(@RequestBody Project project) {
        System.out.println("save: " + project);
        service.save(project);
    }

}
