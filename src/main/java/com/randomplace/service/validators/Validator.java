package com.randomplace.service.validators;

import java.util.List;

public interface Validator {

    void validate(Object object, List<String> errorMessages);

    static boolean isNullOrEmpty(String field) {
        return field == null || field.isEmpty();
    }

}
