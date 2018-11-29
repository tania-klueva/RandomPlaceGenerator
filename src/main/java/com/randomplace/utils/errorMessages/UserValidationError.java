package com.randomplace.utils.errorMessages;

public enum UserValidationError {
    USER_NULL("You have to fill all fields."),
    ID_ERROR("Id should be positive integer number."),
    EMAIL_EXIST_ERROR("Email already exist."),
    EMAIL_EMPTY_ERROR("Please write your email."),
    EMAIL_FORMAT_ERROR("Please write valid email."),
    PASSWORD_NOT_MATCHES_ERROR("Password don't matches. Try again."),
    PASSWORD_LENGTH_ERROR("Password should be from 6 to 20 symbs."),
    PASSWORD_EMPTY_ERROR("Please write password."),
    NAME_EMPTY_ERROR("Please write your name."),
    CITY_EMPTY_ERROR("Please write city where you live.");

    private String errorText;

    UserValidationError(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }

}
