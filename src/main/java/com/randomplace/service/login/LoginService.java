package com.randomplace.service.login;

import com.randomplace.models.User;
import com.randomplace.service.user.impl.UserService;
import com.randomplace.utils.errorMessages.LoginError;
import com.randomplace.utils.PasswordEncoder;

import java.util.List;

public class LoginService {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public LoginService() {
        this.userService = new UserService();
        this.passwordEncoder = new PasswordEncoder();
    }

    public User login(String email, String password, List<String> errorList) {
        User user = null;
        try {
            User userDB = userService.findByEmail(email, errorList);
            if (userDB == null){
                errorList.add(LoginError.EMAIL_NOT_EXIST.getErrorText());
            }else{
                if(!passwordEncoder.isMatches(password, userDB.getPassword())){
                    errorList.add(LoginError.PASSWORD_ERROR.getErrorText());
                }else {
                    user = userDB;
                }
            }
        }catch (NullPointerException e){

        }
        return user;
    }

}
