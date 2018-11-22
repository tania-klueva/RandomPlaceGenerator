package com.randomplace.service.user;

import com.randomplace.models.User;

import java.util.List;

public interface IUserService {
    void save(User user, String confirmPassword, List<String> errorList);
    User findByEmail(String email,  List<String> errorList);
    String findUserPasswordByEmail(String email, List<String> errorList);
    User findById(int id,  List<String> errorList);
    List<User> findAll();
    void update(User user, String confirmPassword, List<String> errorList);
    void updatePassword(User user, String oldPassword, String newPassword, String confirmPassword, List<String> errorList);
    void deleteById(int id,  List<String> errorList);
}
