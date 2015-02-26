package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.RequirementDAO;
import com.sadvit.persistence.domain.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementService {

    @Autowired
    private RequirementDAO requirementDAO;

    public List<Requirement> getAll() {
        return requirementDAO.readAll();
    }

    public void save(Requirement requirement) {
        requirementDAO.create(requirement);
    }

}
