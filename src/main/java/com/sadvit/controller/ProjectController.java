package com.sadvit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public @ResponseBody List<Project> getProjects() {
        return projectService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Project getProject(@PathVariable("id") Integer id) {
        return projectService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public @ResponseBody void putProject(@RequestParam(value = "project") String sproject) throws IOException {
        Project project = mapper.readValue(sproject, Project.class);
        projectService.save(project);
    }

}