package com.randomplace.service.place;

import com.randomplace.models.Place;
import com.randomplace.utils.PlaceSortingField;

import java.util.List;

public interface IPlaceService {
    void save(Place place, List<String> errorList);
    Place findById(int id, List<String> errorList);
    Place findBySpecification(String specification, List<String> errorList);
    List<Place> findAll();
    List<Place> findAllByPage(int page, int count, PlaceSortingField field, List<String> errorList);
    void update(Place place, List<String> errorList);
    void deleteById(int id, List<String> errorList);
}
