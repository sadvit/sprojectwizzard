package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.CategoriesDAO;
import com.sadvit.persistence.domain.ProjectsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesDAO categoriesDAO;

    public List<ProjectsCategory> getRootCategories() {
        return null;
    }

    public List<ProjectsCategory> getAll() {
        return categoriesDAO.readAll();
    }

}
