package com.javalearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String URL = "jdbc:mysql://localhost:3306/movies?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private Connection createConnection() throws ClassNotFoundException {

        Connection con = null;

        try {

            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (SQLException e){

            e.printStackTrace();

        }

        return con;
    }

    public Connection getConnection(){

        try {

            return createConnection();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return  null;
    }
}
