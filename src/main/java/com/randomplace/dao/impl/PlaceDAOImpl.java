package com.randomplace.dao.impl;

import com.randomplace.connection.DBConnection;
import com.randomplace.dao.PlaceDAO;
import com.randomplace.models.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAOImpl implements PlaceDAO {

    Connection connection;

    public PlaceDAOImpl() {
        try {
            this.connection = new DBConnection().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(Place place) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Place(name, specification, address, description) VALUE (?,?,?,?)");
            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getSpecification());
            preparedStatement.setString(3, place.getAddress());
            preparedStatement.setString(4, place.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Place findById(int id) {
        Place place = new Place();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, specification, address, description from Place where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                place.setId(resultSet.getInt(1));
                place.setName(resultSet.getString(2));
                place.setSpecification(resultSet.getString(3));
                place.setAddress(resultSet.getString(4));
                place.setDescription(resultSet.getString(5));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return place;
    }

    public Place findBySpecification(String specification) {
        return null;
    }

    public List<Place> findAll() {
        List<Place> places = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT id, name, specification, address, description from Place").executeQuery();
            while (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getInt(1));
                place.setName(resultSet.getString(2));
                place.setSpecification(resultSet.getString(3));
                place.setAddress(resultSet.getString(4));
                place.setDescription(resultSet.getString(5));
                places.add(place);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return places;
    }

    public void update(Place place) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Place SET "
                    + "name = ?, "
                    + "specification = ?, "
                    + "address =  ?, "
                    + "description = ? "
                    + "WHERE id = ?");
            preparedStatement.setString(1, place.getName());
            preparedStatement.setString(2, place.getSpecification());
            preparedStatement.setString(3, place.getAddress());
            preparedStatement.setString(4, place.getDescription());
            preparedStatement.setInt(5, place.getId());
            preparedStatement.executeUpdate();

            } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from Place where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
