package com.sadvit.controller;

import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.service.ProjectService;
import com.sadvit.persistence.service.RequirementService;
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
    private ProjectService projectService;

    @Autowired
    private RequirementService requirementService;

    @RequestMapping(method = RequestMethod.GET, value = "/all_projects")
    public @ResponseBody List<Project> all_projects() {
        return projectService.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/project")
    public @ResponseBody void project(@RequestBody Project project) {
        System.out.println("save: " + project);
        projectService.save(project);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public @ResponseBody void save() {
        Project p = new Project();
        p.setName("NEW");
        p.setDescription("NEW");

        projectService.save(p);

        Requirement r = new Requirement();
        r.setName("TESTR");
        r.setProject(p);

        requirementService.save(r);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/log")
    public @ResponseBody void log () {
        System.out.println("PROJECTS: ");
        for (Project p : projectService.getAll()) {
            System.out.println(p);
        }
        System.out.println("REQUIREMENTS: ");
        for (Requirement r : requirementService.getAll()) {
            System.out.println(r);
        }
    }

}
