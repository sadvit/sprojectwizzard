package com.sadvit.controller;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Employee getProject(@PathVariable("id") Integer id) {
        return employeeService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postProject(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void putProject(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

}