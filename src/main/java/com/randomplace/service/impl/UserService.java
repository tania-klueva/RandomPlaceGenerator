package com.randomplace.service.impl;

import com.randomplace.dao.impl.UserDAO;
import com.randomplace.models.User;
import com.randomplace.service.IUserService;

import java.util.List;

public class UserService implements IUserService {


    UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public String findUserPasswordByEmail(String email) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
