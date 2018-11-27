package com.randomplace.service.user;

import com.randomplace.dto.UserDTO;
import com.randomplace.models.User;

import java.util.List;

public interface IUserService {
    void save(UserDTO userDTO, List<String> errorList);

    User findByEmail(UserDTO userDTO, List<String> errorList);

    User findById(UserDTO userDTO, List<String> errorList);

    List<User> findAll();

    void update(UserDTO userDTO, List<String> errorList);

    void updatePassword(UserDTO userDTO, List<String> errorList);

    void deleteById(UserDTO userDTO, List<String> errorList);
}
