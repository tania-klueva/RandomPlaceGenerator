package com.randomplace.utils.errorMessages;

public enum PlaceValidationError {
    PLACE_NULL("You have to fill all fields."),
    ID_ERROR("Id should be positive integer number."),
    NAME_EMPTY_ERROR("Please write a name."),
    SPECIFICATION_EMPTY_ERROR("Please write a specification"),
    CITY_EMPTY_ERROR("Please write location."),
    ADDRESS_EMPTY_ERROR("Please write address"),
    DESCRIPTION_EMPTY_ERROR("Please write some information about your place"),
    WRONG_PAGE("Wrong page number"),
    WRONG_COUNT("Wrong number of items per page. It should be from 15 to 90"),
    NO_PLACES_IN_DB("There are no places"),
    FILE_ERROR("Wrong image extension");

    private String errorText;

    PlaceValidationError(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
