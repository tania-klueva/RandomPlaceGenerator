package com.randomplace.dao.impl;

import com.randomplace.connection.DBConnection;
import com.randomplace.dao.IPlaceDAO;
import com.randomplace.models.Place;
import com.randomplace.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAO implements IPlaceDAO {

    private Connection connection;

    public PlaceDAO() {
        this.connection = DBConnection.getConnection();
    }

    public void save(Place place) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Places(name, specification, city, address, description, imagePath, userId) VALUE (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getSpecification());
            preparedStatement.setString(3, place.getCity());
            preparedStatement.setString(4, place.getAddress());
            preparedStatement.setString(5, place.getDescription());
            preparedStatement.setString(6, place.getImagePath());
            preparedStatement.setInt(7, place.getUser().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public Place findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, specification, city, address, description, imagePath, userId from Places where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getInt(1));
                place.setName(resultSet.getString(2));
                place.setSpecification(resultSet.getString(3));
                place.setCity(resultSet.getString(4));
                place.setAddress(resultSet.getString(5));
                place.setDescription(resultSet.getString(6));
                place.setImagePath(resultSet.getString(7));
                place.setUser(new User(resultSet.getInt(8)));
                return place;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public Place findBySpecification(String specification) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, specification, city, address, description, imagePath, userId from Places where specification = ?");
            preparedStatement.setString(1, specification);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getInt(1));
                place.setName(resultSet.getString(2));
                place.setSpecification(resultSet.getString(3));
                place.setCity(resultSet.getString(4));
                place.setAddress(resultSet.getString(5));
                place.setDescription(resultSet.getString(6));
                place.setImagePath(resultSet.getString(7));
                place.setUser(new User(resultSet.getInt(8)));
                return place;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public int getMaxId() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) from Places ");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public List<Place> findAll() {

        try {
            List<Place> places = new ArrayList<>();
            ResultSet resultSet = connection.prepareStatement("SELECT id, name, specification, city, address, description, imagePath, userId from Places").executeQuery();
            while (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getInt(1));
                place.setName(resultSet.getString(2));
                place.setSpecification(resultSet.getString(3));
                place.setCity(resultSet.getString(4));
                place.setAddress(resultSet.getString(5));
                place.setDescription(resultSet.getString(6));
                place.setImagePath(resultSet.getString(7));
                places.add(place);
            }
            return places;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Place place) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Places SET "
                    + "name = ?, "
                    + "specification = ?, "
                    + "city = ?, "
                    + "address =  ?, "
                    + "description = ?, "
                    + "imagePath = ? "
                    + "WHERE id = ?");
            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getSpecification());
            preparedStatement.setString(3, place.getCity());
            preparedStatement.setString(4, place.getAddress());
            preparedStatement.setString(5, place.getDescription());
            preparedStatement.setString(6, place.getImagePath());
            preparedStatement.setInt(7, place.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from Places where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}