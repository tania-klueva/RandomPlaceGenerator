package com.randomplace.dao;

import com.randomplace.models.Place;

import java.util.List;

public interface PlaceDAO {
    void save(Place place);
    Place findById(int id);
    Place findBySpecification(String specification);
    List<Place> findAll();
    void update(Place place);
    void deleteById(int id);
}
