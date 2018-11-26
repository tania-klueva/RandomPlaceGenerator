package com.randomplace.service.user.impl;

import com.randomplace.dao.impl.UserDAO;
import com.randomplace.models.User;
import com.randomplace.service.user.IUserService;
import com.randomplace.service.validators.UserValidator;
import com.randomplace.utils.PasswordEncoder;
import com.randomplace.utils.errorMessages.LoginError;
import com.randomplace.utils.errorMessages.UserValidationError;

import java.util.List;

public class UserService implements IUserService {

    private static UserService ourInstance = new UserService();
    private UserDAO userDAO;
    private UserValidator userValidator;
    private PasswordEncoder passwordEncoder;


    private UserService() {
        this.userValidator = UserValidator.getOurInstance();
        this.userDAO = UserDAO.getOurInstance();
        this.passwordEncoder = PasswordEncoder.getOurInstance();
    }

    public static UserService getOurInstance() {
        return ourInstance;
    }

    @Override
    public void save(User user, String confirmPassword, List<String> errorList) {
        if (userValidator.validatePasswords(user.getPassword(), confirmPassword, errorList)) {
            userValidator.validate(errorList, user);
            if (errorList.isEmpty()) {
                if (userDAO.findByEmail(user.getEmail()) != null) {
                    errorList.add(UserValidationError.EMAIL_EXIST_ERROR.getErrorText());
                } else {
                    passwordEncoder.encodePassword(user);
                    userDAO.save(user);
                }
            }
        } else {
            errorList.add(UserValidationError.PASSWORD_NOT_MATCHES_ERROR.getErrorText());
        }
    }

    @Override
    public User findByEmail(String email, List<String> errorList) {
        if (userValidator.isNullOrEmpty(email)) {
            errorList.add(UserValidationError.EMAIL_EMPTY_ERROR.getErrorText());
        } else {
            return userDAO.findByEmail(email);
        }
        return null;
    }


    @Override
    public User findById(String id, List<String> errorList) {
        if (userValidator.isNullOrEmpty(id)) {
            errorList.add(UserValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(id);
            if (parseInt <= 0) {
                errorList.add(UserValidationError.ID_ERROR.getErrorText());
            } else {
                return userDAO.findById(parseInt);
            }
        }
        return null;
    }


    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void update(User user, List<String> errorList) {
        userValidator.validate(errorList, user);
        if (errorList.isEmpty()) {
            passwordEncoder.encodePassword(user);
            userDAO.update(user);
        }
    }

    @Override
    public void updatePassword(User user, String oldPassword, String newPassword, String confirmPassword, List<String> errorList) {
        if (userValidator.isNullOrEmpty(oldPassword) || userValidator.isNullOrEmpty(newPassword) || userValidator.isNullOrEmpty(confirmPassword)) {
            errorList.add(UserValidationError.PASSWORD_EMPTY_ERROR.getErrorText());
        } else {
            if (!passwordEncoder.isMatches(oldPassword, user.getPassword())) {
                errorList.add(LoginError.PASSWORD_ERROR.getErrorText());
            } else {
                userValidator.validatePasswords(newPassword, confirmPassword, errorList);
                if (errorList.isEmpty()) {
                    user.setPassword(newPassword);
                    passwordEncoder.encodePassword(user);
                    userDAO.updatePassword(user);
                }
            }
        }

    }

    @Override
    public void deleteById(String id, List<String> errorList) {
        if (userValidator.isNullOrEmpty(id)) {
            errorList.add(UserValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(id);
            if (parseInt <= 0) {
                errorList.add(UserValidationError.ID_ERROR.getErrorText());
            } else {
                userDAO.deleteById(parseInt);
            }
        }

    }

}
