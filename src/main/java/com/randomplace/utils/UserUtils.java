package com.randomplace.utils;

import com.randomplace.dto.UserDTO;
import com.randomplace.models.User;
import com.randomplace.service.validators.Validator;

public class UserUtils {
    private static UserUtils ourInstance = new UserUtils();

    public static UserUtils getInstance() {
        return ourInstance;
    }

    private UserUtils() {
    }

    public User dtoToEntity(UserDTO userDTO){
        User user = new User();
        String id = userDTO.getId();
        if (!(Validator.isNullOrEmpty(id))) {
            user.setId(Integer.parseInt(id));
        }
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getEncryptedPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setCity(userDTO.getCity());
        return user;
    }
}
