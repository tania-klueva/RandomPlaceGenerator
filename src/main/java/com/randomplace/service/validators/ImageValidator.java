package com.randomplace.service.validators;

import com.randomplace.utils.errorMessages.PlaceValidationError;

import java.util.List;

public class ImageValidator implements Validator {

    private static ImageValidator ourInstance = new ImageValidator();


    private ImageValidator() {
    }

    public static ImageValidator getOurInstance() {
        return ourInstance;
    }


    @Override
    public void validate(Object object, List<String> errorMessages) {
        String contentType = (String) object;
        switch (contentType) {
            case ".jpg":
                break;
            case ".jpeg":
                break;
            case ".png":
                break;
            case ".svg":
                break;
            case ".bmp":
                break;
            case ".gif":
                break;
            default:
                errorMessages.add(PlaceValidationError.FILE_ERROR.getErrorText());
                break;
        }
    }
}
