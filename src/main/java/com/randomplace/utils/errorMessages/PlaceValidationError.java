package com.randomplace.utils.errorMessages;

public enum PlaceValidationError {
    PLACE_NULL("You have to fill all fields."),
    ID_ERROR("Id should be positive integer number."),
    NAME_EMPTY_ERROR("Please write a name."),
    SPECIFICATION_EMPTY_ERROR("Please write a specification"),
    CITY_EMPTY_ERROR("Please write location."),
    ADDRESS_EMPTY_ERROR("Please write address"),
    DESCRIPTION_EMPTY_ERROR("Please write some information about your place")
    ;

    private String errorText;

    PlaceValidationError(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
