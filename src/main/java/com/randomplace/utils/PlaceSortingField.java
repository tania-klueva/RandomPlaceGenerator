package com.randomplace.utils;

public enum PlaceSortingField {
    NAME("name"),
    SPECIFICATION("specification"),
    CITY("city"),
    ID("id");

    private String fieldName;

    PlaceSortingField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
