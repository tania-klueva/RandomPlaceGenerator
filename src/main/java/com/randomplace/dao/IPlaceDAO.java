package com.randomplace.dao;

import com.randomplace.models.Place;

import java.util.List;

public interface IPlaceDAO {
    void save(Place place);

    Place findById(int id);

    Place findBySpecification(String specification);

    int getMaxId();

    List<Place> findAll();

    List<Place> findAllForPages(int page, int count, String fieldToSortBy);

    void update(Place place);

    void deleteById(int id);

    int countRecords();
}
