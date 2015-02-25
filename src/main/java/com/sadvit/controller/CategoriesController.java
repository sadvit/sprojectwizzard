package com.sadvit.controller;

import com.sadvit.persistence.domain.ProjectsCategory;
import com.sadvit.persistence.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all_categories")
    public @ResponseBody List<ProjectsCategory> all_categories() {
        return service.getAll();
    }

}
