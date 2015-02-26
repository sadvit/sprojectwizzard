package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

}
