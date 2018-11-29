package com.randomplace.service.validators;

import com.randomplace.dto.UserDTO;
import com.randomplace.utils.errorMessages.UserValidationError;

import java.util.List;

public class UserValidator implements Validator {
    private static UserValidator ourInstance = new UserValidator();


    private UserValidator() {
    }

    public static UserValidator getOurInstance() {
        return ourInstance;
    }

    @Override
    public void validate(Object object, List<String> errorMessages) {
        UserDTO userDTO = (UserDTO) object;
        if (userDTO == null) {
            errorMessages.add(UserValidationError.USER_NULL.getErrorText());
        } else {
            if (isNullOrEmpty(userDTO.getEmail())) {
                errorMessages.add(UserValidationError.EMAIL_EMPTY_ERROR.getErrorText());
            }
            if (userDTO.getEmail().indexOf("@") <= 0 || userDTO.getEmail().indexOf(".") < userDTO.getEmail().indexOf("@")) {
                errorMessages.add(UserValidationError.EMAIL_FORMAT_ERROR.getErrorText());
            }
            if (isNullOrEmpty(userDTO.getFirstName())) {
                errorMessages.add(UserValidationError.NAME_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(userDTO.getLastName())) {
                errorMessages.add(UserValidationError.NAME_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(userDTO.getCity())) {
                errorMessages.add(UserValidationError.CITY_EMPTY_ERROR.getErrorText());
            }
        }
    }

    public boolean isNullOrEmpty(String field) {
        return field == null || field.isEmpty();
    }


    public boolean validatePasswords(Object object, List<String> errorMessages) {
        UserDTO user = (UserDTO) object;
        if (user == null) {
            errorMessages.add(UserValidationError.USER_NULL.getErrorText());
        } else {
            if (isNullOrEmpty(user.getNewPassword())) {
                errorMessages.add(UserValidationError.PASSWORD_EMPTY_ERROR.getErrorText());
            } else if (user.getNewPassword().length() < 6 || user.getNewPassword().length() > 20) {
                errorMessages.add(UserValidationError.PASSWORD_LENGTH_ERROR.getErrorText());
            } else {
                return user.getNewPassword().equals(user.getConfirmPassword());
            }
        }
        return false;
    }
}
