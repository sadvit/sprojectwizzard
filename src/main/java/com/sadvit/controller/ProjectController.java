package com.sadvit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    public @ResponseBody List<Project> projects() {
        return projectService.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/project")
    public @ResponseBody void project(@RequestParam(value = "project") String sproject) throws IOException {
        Project project = mapper.readValue(sproject, Project.class);
        projectService.save(project);
    }

}
