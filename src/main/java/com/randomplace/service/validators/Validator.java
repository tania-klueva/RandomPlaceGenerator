package com.randomplace.service.validators;

import java.util.List;

public interface Validator {

    void validate(List<String> errorMessages, Object object);
    boolean isNullOrEmpty(String field);
}
