package com.randomplace.service.user.impl;

import com.randomplace.dao.impl.UserDAO;
import com.randomplace.dto.UserDTO;
import com.randomplace.models.User;
import com.randomplace.service.user.IUserService;
import com.randomplace.service.validators.UserValidator;
import com.randomplace.utils.PasswordEncoder;
import com.randomplace.utils.UserUtils;
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
    public void save(UserDTO userDTO, List<String> errorList) {
        if (userValidator.validatePasswords(userDTO, errorList)) {
            userValidator.validate(userDTO, errorList);
            if (errorList.isEmpty()) {
                if (userDAO.findByEmail(userDTO.getEmail()) != null) {
                    errorList.add(UserValidationError.EMAIL_EXIST_ERROR.getErrorText());
                } else {
                    passwordEncoder.encodePassword(userDTO);
                    userDAO.save(UserUtils.getInstance().dtoToEntity(userDTO));
                }
            }
        } else {
            errorList.add(UserValidationError.PASSWORD_NOT_MATCHES_ERROR.getErrorText());
        }
    }

    @Override
    public User findByEmail(UserDTO userDTO, List<String> errorList) {
        if (userValidator.isNullOrEmpty(userDTO.getEmail())) {
            errorList.add(UserValidationError.EMAIL_EMPTY_ERROR.getErrorText());
        } else {
            return userDAO.findByEmail(userDTO.getEmail());
        }
        return null;
    }

    @Override
    public User findById(UserDTO userDTO, List<String> errorList) {
        if (userValidator.isNullOrEmpty(userDTO.getId())) {
            errorList.add(UserValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(userDTO.getId());
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
    public void update(UserDTO userDTO, List<String> errorList) {
        userValidator.validate(userDTO, errorList);
        if (errorList.isEmpty()) {
            userDAO.update(UserUtils.getInstance().dtoToEntity(userDTO));
        }
    }

    @Override
    public void updatePassword(UserDTO userDTO, List<String> errorList) {
        userValidator.validatePasswords(userDTO, errorList);
        if (!passwordEncoder.isMatches(userDTO)) {
            errorList.add(LoginError.PASSWORD_ERROR.getErrorText());
        } else {
            if (errorList.isEmpty()) {
                passwordEncoder.encodePassword(userDTO);
                userDAO.updatePassword(UserUtils.getInstance().dtoToEntity(userDTO));
            }
        }

    }

    @Override
    public void deleteById(UserDTO userDTO, List<String> errorList) {
        if (userValidator.isNullOrEmpty(userDTO.getId())) {
            errorList.add(UserValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(userDTO.getId());
            if (parseInt <= 0) {
                errorList.add(UserValidationError.ID_ERROR.getErrorText());
            } else {
                userDAO.deleteById(parseInt);
            }
        }
    }


}
