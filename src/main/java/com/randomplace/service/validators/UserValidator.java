package com.randomplace.service.validators;

import com.randomplace.models.User;
import com.randomplace.utils.errorMessages.UserValidationError;

import java.util.List;

public class UserValidator implements Validator{
    private static UserValidator ourInstance = new UserValidator();


    public static UserValidator getOurInstance() {
        return ourInstance;
    }

    private UserValidator() {
    }

    @Override
    public void validate(List<String> errorMessages, Object object) {
        User user = (User) object;
        if (user==null) {
            errorMessages.add(UserValidationError.USER_NULL.getErrorText());
        }else{
            if (isNullOrEmpty(user.getEmail())){
                errorMessages.add(UserValidationError.EMAIL_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(user.getFirstName())){
                errorMessages.add(UserValidationError.NAME_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(user.getCity())){
                errorMessages.add(UserValidationError.CITY_EMPTY_ERROR.getErrorText());
            }
        }
    }

    public boolean isNullOrEmpty(String field){
        return field == null || field.isEmpty();
    }


    public boolean validatePasswords(String password, String confirmPassword, List<String> errorMessages){
        if (isNullOrEmpty(password)){
            errorMessages.add(UserValidationError.PASSWORD_EMPTY_ERROR.getErrorText());
        } else if (password.length() < 6 || password.length() > 20){
            errorMessages.add(UserValidationError.PASSWORD_LENGTH_ERROR.getErrorText());
        } else {
            return password.equals(confirmPassword);
        }
        return false;
    }


}
