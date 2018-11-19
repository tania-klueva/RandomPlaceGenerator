package com.randomplace.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private static DBConnection ourInstance = new DBConnection();

    public static DBConnection getInstance() {
        return ourInstance;
    }

    public static Connection getConnection() {
        return connection;
    }

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/randomPlaces", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

