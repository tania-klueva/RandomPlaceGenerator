package com.randomplace.service.user;

import com.randomplace.models.User;

import java.util.List;

public interface IUserService {
    void save(User user, String confirmPassword, List<String> errorList);

    User findByEmail(String email, List<String> errorList);

    User findById(String id, List<String> errorList);

    List<User> findAll();

    void update(User user, List<String> errorList);

    void updatePassword(User user, String oldPassword, String newPassword, String confirmPassword, List<String> errorList);

    void deleteById(String id, List<String> errorList);
}
