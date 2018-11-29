package com.randomplace.service.validators;

import java.util.List;

public interface Validator {

    static boolean isNullOrEmpty(String field) {
        return field == null || field.isEmpty();
    }

    void validate(Object object, List<String> errorMessages);

}
