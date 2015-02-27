package com.sadvit.controller;

import com.sadvit.persistence.domain.Requirement;
import com.sadvit.persistence.service.ProjectService;
import com.sadvit.persistence.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.err.println(projectService.get(id).getRequirements());
        return projectService.get(id).getRequirements();
    }
}
