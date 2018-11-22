package com.randomplace.service.validators;

import com.randomplace.models.Place;
import com.randomplace.utils.errorMessages.PlaceValidationError;

import java.util.List;

public class PlaceValidator implements Validator {
    private static PlaceValidator ourInstance = new PlaceValidator();


    public static PlaceValidator getOurInstance() {
        return ourInstance;
    }

    private PlaceValidator() {
    }


    @Override
    public void validate(List<String> errorMessages, Object object) {
        Place place = (Place) object;
        if (place == null){
            errorMessages.add(PlaceValidationError.PLACE_NULL.getErrorText());
        }else{
            if (isNullOrEmpty(place.getName())){
                errorMessages.add(PlaceValidationError.NAME_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(place.getSpecification())){
                errorMessages.add(PlaceValidationError.SPECIFICATION_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(place.getCity())){
                errorMessages.add(PlaceValidationError.CITY_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(place.getAddress())){
                errorMessages.add(PlaceValidationError.ADDRESS_EMPTY_ERROR.getErrorText());
            }
            if (isNullOrEmpty(place.getDescription())){
                errorMessages.add(PlaceValidationError.DESCRIPTION_EMPTY_ERROR.getErrorText());
            }
        }
    }


    @Override
    public boolean isNullOrEmpty(String field) {
        return field == null || field.isEmpty();
    }
}
