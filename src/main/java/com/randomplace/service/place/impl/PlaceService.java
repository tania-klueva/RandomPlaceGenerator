package com.randomplace.service.place.impl;

import com.randomplace.dao.impl.PlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.service.place.IPlaceService;
import com.randomplace.service.validators.PlaceValidator;
import com.randomplace.utils.errorMessages.PlaceValidationError;

import java.util.List;

public class PlaceService implements IPlaceService {

    private PlaceDAO placeDAO;
    private PlaceValidator validator;

    public PlaceService() {
        this.placeDAO = new PlaceDAO();
        validator = new PlaceValidator();
    }

    @Override
    public void save(Place place, List<String> errorList) {
        validator.validate(errorList, place);
        if (errorList.isEmpty()){
            placeDAO.save(place);
        }
    }

    @Override
    public Place findById(int id, List<String> errorList) {
        if(id<=0){
            errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
        }else{
            return placeDAO.findById(id);
        }
        return null;
    }

    @Override
    public Place findBySpecification(String specification, List<String> errorList) {
        if (validator.isNullOrEmpty(specification)) {
            errorList.add(PlaceValidationError.SPECIFICATION_EMPTY_ERROR.getErrorText());
        }else{
            return placeDAO.findBySpecification(specification);
        }
        return null;
    }

    @Override
    public List<Place> findAll(){
        return placeDAO.findAll();
    }

    @Override
    public void update(Place place, List<String> errorList) {
        validator.validate(errorList, place);
        if (errorList.isEmpty()){
            placeDAO.update(place);
        }
    }

    @Override
    public void deleteById(int id, List<String> errorList) {
        if(id<=0){
            errorList.add(PlaceValidationError.ID_ERROR.getErrorText());
        }else{
            placeDAO.deleteById(id);
        }
    }

}
