package com.randomplace.utils.errorMessages;

public enum LoginError {
    EMAIL_NOT_EXIST("This email doesn't exist, try again."),
    PASSWORD_ERROR("You entered wrong password, try again.");

    private String errorText;

    LoginError(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
