package com.randomplace.dao.impl;

import com.randomplace.connection.DBConnection;
import com.randomplace.dao.IUserDAO;
import com.randomplace.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private static UserDAO ourInstance = new UserDAO();

    private Connection connection;

    public static UserDAO getOurInstance() {
        return ourInstance;
    }

    private UserDAO() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(email, password, firstName, lastName, city) VALUE (?,?,?,?,?)");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, password, firstName, lastName, city from Users where email like ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setCity(resultSet.getString(6));
                return user;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findUserPasswordByEmail(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password from Users where email like ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString(1);
                return password;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, password, firstName, lastName, city from Users where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setCity(resultSet.getString(6));
                return user;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            ResultSet resultSet = connection.prepareStatement("SELECT id, email, password, firstName, lastName, city from Users").executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setCity(resultSet.getString(6));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Users SET "
                    + "email = ?, "
                    + "firstname = ?, "
                    + "lastname =  ?, "
                    + "city = ? "
                    + "WHERE id = ?");
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePassword(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Users SET "
                    + "password = ? "
                    + "WHERE id = ?");
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from Users where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
