package com.randomplace.service.validators;

import com.randomplace.utils.errorMessages.PlaceValidationError;

import javax.servlet.http.Part;
import java.util.List;

public class ImageValidator implements Validator {

    private static ImageValidator ourInstance = new ImageValidator();


    public static ImageValidator getOurInstance() {
        return ourInstance;
    }

    private ImageValidator() {
    }

    @Override
    public void validate(List<String> errorMessages, Object object) {
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


    @Override
    public boolean isNullOrEmpty(String field) {
        return false;
    }
}
