package com.sadvit.persistence.service;

import com.sadvit.persistence.dao.UserDAO;
import com.sadvit.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getAuthUser(String loing, String pass) {
        return userDAO.getAuth(loing, pass);
    }

}
