package com.randomplace.service.place.impl;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.service.place.IPlaceService;
import com.randomplace.service.validators.PlaceValidator;
import com.randomplace.utils.PlaceSortingField;
import com.randomplace.utils.errorMessages.PlaceValidationError;

import java.util.List;

public class PlaceService implements IPlaceService {

    private PlaceDAO placeDAO;
    private PlaceValidator validator;
    private static PlaceService ourInstance = new PlaceService();


    public static PlaceService getOurInstance() {
        return ourInstance;
    }

    private PlaceService() {
        placeDAO = PlaceDAO.getOurInstance();
        validator = PlaceValidator.getOurInstance();
    }

    @Override
    public void save(Place place, List<String> errorList) {
        validator.validate(errorList, place);
        if (errorList.isEmpty()) {
            placeDAO.save(place);
        }
    }

    @Override
    public Place findById(String id, List<String> errorList) {
        if (validator.isNullOrEmpty(id)) {
            errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(id);
            if (parseInt <= 0) {
                errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
            } else {
                return placeDAO.findById(parseInt);
            }
        }
        return null;
    }

    @Override
    public Place findBySpecification(String specification, List<String> errorList) {
        if (validator.isNullOrEmpty(specification)) {
            errorList.add(PlaceValidationError.SPECIFICATION_EMPTY_ERROR.getErrorText());
        } else {
            return placeDAO.findBySpecification(specification);
        }
        return null;
    }

    @Override
    public List<Place> findAll() {
        return placeDAO.findAll();
    }

    @Override
    public List<Place> findAllByPage(String pageString, String countString, PlaceSortingField field, List<String> errorList) {
        if (validator.isNullOrEmpty(pageString)) {
            errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
        }
        if (validator.isNullOrEmpty(countString)) {
            errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
        }
        if (errorList.isEmpty()) {
            int page = Integer.parseInt(pageString);
            int count = Integer.parseInt(countString);
            if (page <= 0) {
                errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
            }
            if (count < 15 || count > 90) {
                errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
            } else {
                if (errorList.isEmpty()) {
                    return placeDAO.findAllForPages(page, count, field.getFieldName());
                }
            }
        }
        return null;
    }

    @Override
    public void update(Place place, List<String> errorList) {
        validator.validate(errorList, place);
        if (errorList.isEmpty()) {
            placeDAO.update(place);
        }
    }

    @Override
    public void deleteById(String id, List<String> errorList) {
        if (validator.isNullOrEmpty(id)) {
            errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
        } else {
            int parseInt = Integer.parseInt(id);
            if (parseInt <= 0) {
                errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
            } else {
                placeDAO.deleteById(parseInt);
            }
        }

    }

}
