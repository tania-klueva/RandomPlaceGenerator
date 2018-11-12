package com.randomplace.models;

public class Place {

    private int id;
    private String name;
    private String specification;
    private String address;
    private String description;

    public Place() {
    }

    public Place(int id, String name, String address, String description, String specification) {
        this.id = id;
        this.name = name;
        this.specification = specification;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
