package com.randomplace.models;

import java.util.Objects;

public class Place {

    private int id;
    private String name;
    private String specification;
    private String city;
    private String address;
    private String description;
    private String imagePath;

    public Place() {
    }

    public Place(int id, String name, String specification, String city, String address, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.specification = specification;
        this.city = city;
        this.address = address;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Place(String name, String specification, String city, String address, String description, String imagePath) {
        this.name = name;
        this.specification = specification;
        this.city = city;
        this.address = address;
        this.description = description;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id &&
                Objects.equals(name, place.name) &&
                Objects.equals(specification, place.specification) &&
                Objects.equals(city, place.city) &&
                Objects.equals(address, place.address) &&
                Objects.equals(description, place.description) &&
                Objects.equals(imagePath, place.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specification, city, address, description, imagePath);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
