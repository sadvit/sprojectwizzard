package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class TeamDAO extends AbstractDAO<Team> {

    public TeamDAO() {
        super(Team.class);
    }

}
