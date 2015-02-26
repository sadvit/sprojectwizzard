package com.sadvit.controller;

import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * При входе возвращается объект User, в нем в зависимости от прав
 * содержится либо обьект Employee, либо объект Manager.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "?{login}&{pass}")
    public @ResponseBody User getProjects(@PathVariable("login") String login, @PathVariable("pass") String pass) {
        if (login != null && pass != null) return userService.getAuthUser(login, pass);
        return null;
    }

}
