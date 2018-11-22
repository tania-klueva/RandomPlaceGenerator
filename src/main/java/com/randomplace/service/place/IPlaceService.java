package com.randomplace.service.place;

import com.randomplace.models.Place;
import com.randomplace.utils.PlaceSortingField;

import java.util.List;

public interface IPlaceService {
    void save(Place place, List<String> errorList);
    Place findById(String id, List<String> errorList);
    Place findBySpecification(String specification, List<String> errorList);
    List<Place> findAll();
    List<Place> findAllByPage(String page, String count, PlaceSortingField field, List<String> errorList);
    void update(Place place, List<String> errorList);
    void deleteById(String id, List<String> errorList);
}
