package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.TeamDAO;
import com.sadvit.persistence.domain.Employee;
import com.sadvit.persistence.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamDAO teamDAO;

    public void save(Team team) {
    // TODO проверить некорректное замещение данных...
        // TODO лучше брать их из базы, связывать и потом уже сохранять,
        // TODO не знаю как себя поведут при нуллах, обновятся ли?
        reference(team);
        teamDAO.save(team);
    }

    public Team get(Integer id) {
        return teamDAO.load(id);
    }

    public List<Team> getAll() {
        return teamDAO.loadAll();
    }

    private void reference(Team team) {
        if (team.getEmployees() != null) {
            for (Employee employee : team.getEmployees()) {
                employee.setTeam(team);
            }
        }
    }

}