package com.randomplace.service.place.impl;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.service.place.IPlaceService;
import com.randomplace.service.validators.PlaceValidator;
import com.randomplace.service.validators.Validator;
import com.randomplace.utils.PlaceSortingField;
import com.randomplace.utils.errorMessages.PlaceValidationError;
import com.randomplace.utils.errorMessages.UserValidationError;

import java.util.List;

public class PlaceService implements IPlaceService {

    private static PlaceService ourInstance = new PlaceService();
    private PlaceDAO placeDAO;
    private PlaceValidator validator;


    private PlaceService() {
        placeDAO = PlaceDAO.getOurInstance();
        validator = PlaceValidator.getOurInstance();
    }

    public static PlaceService getOurInstance() {
        return ourInstance;
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
        if (Validator.isNullOrEmpty(id)) {
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
    public Place findById(int id) {
        if (id <= 0) {
            return null;
        } else {
            return placeDAO.findById(id);
        }
    }

    @Override
    public int findMaxId() {
        return placeDAO.getMaxId();
    }

    @Override
    public Place findBySpecification(String specification, List<String> errorList) {
        if (Validator.isNullOrEmpty(specification)) {
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
        if (Validator.isNullOrEmpty(pageString)) {
            errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
        }
        if (Validator.isNullOrEmpty(countString)) {
            errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
        }
        if (errorList.isEmpty()) {
            int page = Integer.parseInt(pageString);
            int count = Integer.parseInt(countString);
            if (page <= 0) {
                errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
            }
            if (count < 5 || count > 90) {
                errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
            } else {
                if (errorList.isEmpty()) {
                    List<Place> forPagesByUserId = placeDAO.findAllForPages(page, count, field.getFieldName());
                    if (!forPagesByUserId.isEmpty()) {
                        return forPagesByUserId;
                    }
                }
            }
        }
        errorList.add(PlaceValidationError.NO_PLACES_IN_DB.getErrorText());
        return null;
    }

    @Override
    public List<Place> findForPagesByUserId(int userId, String pageString, String countString, PlaceSortingField field, List<String> errorList) {
        if (Validator.isNullOrEmpty(pageString)) {
            errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
        }
        if (Validator.isNullOrEmpty(countString)) {
            errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
        }
        if (errorList.isEmpty()) {
            int page = Integer.parseInt(pageString);
            int count = Integer.parseInt(countString);
            if (userId <= 0) {
                errorList.add(UserValidationError.ID_ERROR.getErrorText());
            }
            if (page <= 0) {
                errorList.add(PlaceValidationError.WRONG_PAGE.getErrorText());
            }
            if (count < 3 || count > 15) {
                errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
            } else {
                if (errorList.isEmpty()) {
                    List<Place> forPagesByUserId = placeDAO.findForPagesByUserId(userId, page, count, field.getFieldName());
                    if (!forPagesByUserId.isEmpty()) {
                        return forPagesByUserId;
                    }
                }
            }
        }
        errorList.add(PlaceValidationError.NO_PLACES_IN_DB.getErrorText());
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
        if (Validator.isNullOrEmpty(id)) {
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

    @Override
    public int countNumberOfPages(String countString, List<String> errorList) {
        if (Validator.isNullOrEmpty(countString)) {
            errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
        }
        if (errorList.isEmpty()) {
            int count = Integer.parseInt(countString);
            if (count < 15 || count > 90) {
                errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
            } else {
                if (errorList.isEmpty()) {
                    double i = placeDAO.countRecords();
                    if (i != -1) {
                        return (int) Math.ceil(i / count);
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public int countNumberOfPagesByUserId(int userId, String countString, List<String> errorList) {
        if (Validator.isNullOrEmpty(countString)) {
            errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
        }
        if (userId <= 0) {
            errorList.add(UserValidationError.ID_ERROR.getErrorText());
        }
        if (errorList.isEmpty()) {
            int count = Integer.parseInt(countString);
            if (count < 3 || count > 10) {
                errorList.add(PlaceValidationError.WRONG_COUNT.getErrorText());
            } else {
                double i = placeDAO.countRecordsById(userId);
                if (i != -1) {
                    return (int) Math.ceil(i / count);
                }
            }
        }
        return -1;
    }

}
