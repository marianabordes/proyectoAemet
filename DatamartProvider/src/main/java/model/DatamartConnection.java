package model;

import java.sql.*;

public class DatamartConnection {
    private final Connection connection; // está bien esto como final?

    public DatamartConnection() {
        this.connection = connect();
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datamart.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
