package com.sadvit.controller;

import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.Team;
import com.sadvit.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Project> getProjects(@CookieValue Integer id) {
        return projectService.getAll(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Project getProject(@PathVariable("id") Integer id) {
        return projectService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contacts/{id}")
    public @ResponseBody Map<String, String> getContacts(@PathVariable("id") Integer id) {
        return projectService.getContacts(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/team/{id}")
    public @ResponseBody Team getTeam(@PathVariable("id") Integer id) {
        return projectService.get(id).getTeam();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postProject(@RequestBody Project project) {
        projectService.save(project);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void putProject(@RequestBody Project project) {
        projectService.update(project);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteProject(@PathVariable("id") Integer id) {
        projectService.delete(id);
    }

}