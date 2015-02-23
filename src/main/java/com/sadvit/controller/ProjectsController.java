package com.sadvit.controller;

import com.sadvit.persistence.domain.Manager;
import com.sadvit.persistence.domain.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectsController {

    @RequestMapping("/projects")
    public List<Project> projects() {
        List<Project> projects = new ArrayList<Project>();
        for (int i = 0; i < 10; i++) {
            projects.add(new Project("Achievethis" + i, new Manager("Sad", "Vit")));
        }
        return projects;
    }

}
