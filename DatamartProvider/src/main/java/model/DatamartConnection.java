package model;

import java.sql.*;

public class DatamartConnection {
    private final Connection connection;

    public DatamartConnection() {
        this.connection = connect();
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + "datamart.db");
            System.out.println("Succesfull connection");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("connection not established");
        }
        return connection;
    }
}
