package com.randomplace.dao;

import com.randomplace.models.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findByEmail(String email);
    String findUserPasswordByEmail(String email);
    User findById(int id);
    List<User> findAll();
    void update(User user);
    void deleteById(int id);

}
