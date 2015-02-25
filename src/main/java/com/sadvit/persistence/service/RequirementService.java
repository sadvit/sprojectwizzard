package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.RequirementDAO;
import com.sadvit.persistence.domain.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {

    @Autowired
    RequirementDAO requirementDAO;

    public void save(Requirement requirement) {
        requirementDAO.create(requirement);
    }
}
