package com.randomplace.models;

import java.util.Objects;

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

    public Place(String name, String specification, String address, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id &&
                Objects.equals(name, place.name) &&
                Objects.equals(specification, place.specification) &&
                Objects.equals(address, place.address) &&
                Objects.equals(description, place.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specification, address, description);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
