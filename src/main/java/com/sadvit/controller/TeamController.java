package com.sadvit.controller;

import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Team;
import com.sadvit.persistence.domain.User;
import com.sadvit.persistence.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void postTeam(@RequestBody Team team) {
        System.out.println("Team: " + team);
        System.out.println("Emps: " + team.getEmployees());
        teamService.save(team);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody Team getTeam(@PathVariable("id") Integer id) {
        return teamService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void putTeam(@RequestBody Team team) {
        teamService.update(team);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public @ResponseBody void deleteTeam(@PathVariable("id") Integer id) {
        teamService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/full")
    public @ResponseBody List<Team> getTeamsFull() {
        return teamService.getAllFull();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/short")
    public @ResponseBody List<Team> getTeamsShort() {
        return teamService.getAllShort();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/employees")
    public @ResponseBody Set<Employee> getTeamEmployees(@PathVariable("id") Integer id) {
        return teamService.get(id).getEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/users")
    public @ResponseBody Set<User> getTeamUsers(@PathVariable("id") Integer id) {
        Set<Employee> employees = teamService.get(id).getEmployees();
        Set<User> users = new HashSet<User>();
        for (Employee employee : employees) {
            users.add(employee.getUser());
        }
        return users;
    }

}
