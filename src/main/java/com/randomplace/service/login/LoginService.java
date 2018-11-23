package com.randomplace.service.login;

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

    public User login(String email, String password, List<String> errorList) {
        User user = null;
        User userDB = userService.findByEmail(email, errorList);
        if (userDB == null) {
            errorList.add(LoginError.EMAIL_NOT_EXIST.getErrorText());
        } else {
            if (!passwordEncoder.isMatches(password, userDB.getPassword())) {
                errorList.add(LoginError.PASSWORD_ERROR.getErrorText());
            } else {
                user = userDB;
            }
        }
        return user;
    }

}
