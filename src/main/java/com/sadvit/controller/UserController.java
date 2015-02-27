package com.sadvit.controller;

import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return userService.getAll();
    }

    /**
     * Метод обновления пользователя.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void putUser(@RequestBody User user) {
        System.out.println("update");
        userService.update(user);
    }

    /**
     * Метод сохранения пользователя.
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postUser(@RequestBody User user) {
        System.out.println("save");
        userService.save(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

}
