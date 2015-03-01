package com.sadvit.controller;

import com.sadvit.persistence.domain.*;
import com.sadvit.persistence.domain.type.Role;
import com.sadvit.persistence.service.ProjectService;
import com.sadvit.persistence.service.RequirementService;
import com.sadvit.persistence.service.TaskService;
import com.sadvit.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер специально для тестов. Сюда сливать всю тестовую ерунду.
 */
@Controller
public class TestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/test/save")
    public @ResponseBody
    void save() {
        Project p = new Project();
        p.setName("NEW");
        p.setDescription("NEW");

        projectService.save(p);

        Requirement r = new Requirement();
        r.setName("TESTR");
        r.setProject(p);

        requirementService.save(r);

    }

    //@Transactional(readOnly = false)
    @RequestMapping(method = RequestMethod.GET, value = "/suptest")
    public @ResponseBody void suptest() {
        /*Stock stock = new Stock();

        StockDetail stockDetail = new StockDetail();

        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);

        stockDAO.save(stock);*/

        User user = new User();
        user.setLogin("SUPER");
        user.setPass("TEST");

        Employee employee = new Employee();
        employee.setRole(Role.LEADER);

        employee.setUser(user);
        user.setEmployee(employee);

        userService.save(user);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/log")
    public @ResponseBody void log () {
        System.out.println("PROJECTS: ");
        for (Project p : projectService.getAll()) {
            System.out.println(p);
        }
        System.out.println("REQUIREMENTS: ");
        for (Requirement r : requirementService.getAll()) {
            System.out.println(r);
        }
        System.out.println("USERS: ");
        for (User u : userService.getAll()) {
            System.out.println(u);
        }
        System.out.println("TASKS: ");
        for (Task t : taskService.getAll()) {
            System.out.println(t);
        }
    }

}
