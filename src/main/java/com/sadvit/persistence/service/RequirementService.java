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
        return requirementDAO.loadAll();
    }

    public void save(Requirement requirement) {
        requirementDAO.save(requirement);
    }

    public Requirement get(Integer id) {
        return requirementDAO.load(id);
    }

    public void update(Requirement requirement) {
        requirementDAO.update(requirement);
    }

    public void delete(Integer id) {
        requirementDAO.delete(id);
    }
}
