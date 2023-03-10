package model;

import java.sql.*;

public class TableManager {
    public void createTable() {
        String sqlTempMax = """
                CREATE TABLE IF NOT EXISTS tempMax (
                	date String PRIMARY KEY,
                	time String,
                	place String,
                	station String,
                	temp String
                );""";

        String sqlTempMin = """
                CREATE TABLE IF NOT EXISTS tempMin (
                	date String PRIMARY KEY,
                	time String,
                	place String,
                	station String,
                	temp String
                );""";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:datamart.db"); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlTempMax);
            stmt.execute(sqlTempMin);
            System.out.println("Tables created succesfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTempMax(Weather weatherWithMaxTemp, DatamartConnection connection) throws SQLException {

        String sql = "INSERT or REPLACE INTO tempMax(date, time, place, station, temp) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, weatherWithMaxTemp.getDate());
            pstmt.setString(2, weatherWithMaxTemp.getTime());
            pstmt.setString(3, weatherWithMaxTemp.getPlace());
            pstmt.setString(4, weatherWithMaxTemp.getStation());
            pstmt.setDouble(5, weatherWithMaxTemp.getTemp());
            pstmt.execute();
        }
    }

    public void insertTempMin(Weather weatherWithMinTemp, DatamartConnection connection) throws SQLException {

        String sql = "INSERT or REPLACE INTO tempMin(date, time, place, station, temp) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, weatherWithMinTemp.getDate());
            pstmt.setString(2, weatherWithMinTemp.getTime());
            pstmt.setString(3, weatherWithMinTemp.getPlace());
            pstmt.setString(4, weatherWithMinTemp.getStation());
            pstmt.setDouble(5, weatherWithMinTemp.getTemp());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
