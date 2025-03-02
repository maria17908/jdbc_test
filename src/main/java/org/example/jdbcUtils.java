package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test";
    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection( URL , USERNAME , PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nuk lidhem dot me databazen!");
        }
    }
}
