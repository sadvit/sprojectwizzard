package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TaskDAO taskDAO;

}
