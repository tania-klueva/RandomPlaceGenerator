package com.randomplace.service.validators;

import com.randomplace.models.Place;
import com.randomplace.service.image.ImageService;
import com.randomplace.utils.errorMessages.PlaceValidationError;

import java.util.List;

public class PlaceValidator implements Validator {
    private static PlaceValidator ourInstance = new PlaceValidator();


    private PlaceValidator() {
    }

    public static PlaceValidator getOurInstance() {
        return ourInstance;
    }



    @Override
    public void validate(Object object, List<String> errorMessages) {
        Place place = (Place) object;
        if (place == null) {
            errorMessages.add(PlaceValidationError.PLACE_NULL.getErrorText());
        } else {
            if (Validator.isNullOrEmpty(place.getName())) {
                errorMessages.add(PlaceValidationError.NAME_EMPTY_ERROR.getErrorText());
            }
            if (Validator.isNullOrEmpty(place.getSpecification())) {
                errorMessages.add(PlaceValidationError.SPECIFICATION_EMPTY_ERROR.getErrorText());
            }
            if (Validator.isNullOrEmpty(place.getCity())) {
                errorMessages.add(PlaceValidationError.CITY_EMPTY_ERROR.getErrorText());
            }
            if (Validator.isNullOrEmpty(place.getAddress())) {
                errorMessages.add(PlaceValidationError.ADDRESS_EMPTY_ERROR.getErrorText());
            }
            if (Validator.isNullOrEmpty(place.getDescription())) {
                errorMessages.add(PlaceValidationError.DESCRIPTION_EMPTY_ERROR.getErrorText());
            }
            if (Validator.isNullOrEmpty(place.getImagePath())) {
                place.setImagePath(ImageService.DEFAULT_FILE_NAME);
            }
        }
    }
}
