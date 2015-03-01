package com.sadvit.controller;

import com.sadvit.persistence.domain.Project;
import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.service.ProjectService;
import com.sadvit.persistence.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;

@RestController
@RequestMapping("/requirements")
public class RequirementController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RequirementService requirementService;

    @RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}")
    public @ResponseBody Set<Requirement> getAll(@PathVariable("projectId") Integer id) {
        return projectService.get(id).getRequirements();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postRequirement(@RequestBody Requirement requirement) {
        Project project = projectService.get(requirement.getProject().getId());
        requirement.setProject(project);

        requirementService.save(requirement);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Requirement getRequirement(@PathVariable("id") Integer id) {
        return requirementService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void updateRequirement(@RequestBody Requirement requirement) {
        Project project = projectService.get(requirement.getProject().getId());
        requirement.setProject(project);

        requirementService.update(requirement);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteRequirement(@PathVariable("id") Integer id) {
        requirementService.delete(id);
    }

}
