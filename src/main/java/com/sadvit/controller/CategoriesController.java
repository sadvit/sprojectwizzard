package com.sadvit.controller;

import com.sadvit.collection.Tree;
import com.sadvit.persistence.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping("/categories")
    public List<Tree<Category>> categories() {
        /*
        List<Category> categories = new ArrayList<Category>();
        for (int i = 0; i < 10; i++) {
            projects.add(new Project("Achievethis" + i, new Manager("Sad", "Vit")));
        }*/
        return null;
    }

}
