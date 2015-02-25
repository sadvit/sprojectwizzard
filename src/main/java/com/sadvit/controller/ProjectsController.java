package com.sadvit.controller;

import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectsController {

    @Autowired
    private ProjectsService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all_projects")
    public @ResponseBody List<Project> all_projects() {
        return service.getAll();
    }

}
