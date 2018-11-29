package com.randomplace.service.login;

import com.randomplace.dto.UserDTO;
import com.randomplace.models.User;
import com.randomplace.service.user.impl.UserService;
import com.randomplace.utils.PasswordEncoder;
import com.randomplace.utils.errorMessages.LoginError;

import java.util.List;

public class LoginService {

    private static LoginService ourInstance = new LoginService();
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    private LoginService() {
        this.userService = UserService.getOurInstance();
        this.passwordEncoder = PasswordEncoder.getOurInstance();
    }

    public static LoginService getInstance() {
        return ourInstance;
    }

    public User login(UserDTO userDTO, List<String> errorList) {
        User userDB = userService.findByEmail(userDTO, errorList);
        if (userDB == null) {
            errorList.add(LoginError.EMAIL_NOT_EXIST.getErrorText());
        } else {
            userDTO.setEncryptedPassword(userDB.getPassword());
            if (!passwordEncoder.isMatches(userDTO)) {
                errorList.add(LoginError.PASSWORD_ERROR.getErrorText());
            }
        }
        return userDB;
    }

}
