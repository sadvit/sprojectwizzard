package com.sadvit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.PUT, value = "/{user}")
    public @ResponseBody void putUser(@PathVariable("user") String suser) throws IOException {
        User user = mapper.readValue(suser, User.class);
        userService.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

}
