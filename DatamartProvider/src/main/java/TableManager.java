import java.sql.*;

public class TableManager {
    public static void createTable() {
        String path  = "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datamart.db";

        String sqlTempMax = "CREATE TABLE IF NOT EXISTS tempMax (\n"
                + "	date String,\n"
                + "	time String,\n"
                + "	place String,\n"
                + "	station String,\n"
                + "	temp String\n"
                + ");";

        String sqlTempMin = "CREATE TABLE IF NOT EXISTS tempMin (\n"
                + "	date String,\n"
                + "	time String,\n"
                + "	place String,\n"
                + "	station String,\n"
                + "	temp String\n"
                + ");";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + path);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlTempMax);
            // stmt.execute(sqlTempMin);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTempMax(Weather weatherWithMaxTemp, DatamartConnection connection) throws SQLException {

        String sql = "INSERT INTO tempMax(date, time, place, station, temp) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, weatherWithMaxTemp.getDate());
            pstmt.setString(2, weatherWithMaxTemp.getTime());
            pstmt.setString(3, weatherWithMaxTemp.getPlace());
            pstmt.setString(4, weatherWithMaxTemp.getStation());
            pstmt.setFloat(5, weatherWithMaxTemp.getTemp());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTempMin(Weather weatherWithMinTemp, DatamartConnection connection) throws SQLException {

        String sql = "INSERT INTO tempMin(date, time, place, station, temp) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, weatherWithMinTemp.getDate());
            pstmt.setString(2, weatherWithMinTemp.getTime());
            pstmt.setString(3, weatherWithMinTemp.getPlace());
            pstmt.setString(4, weatherWithMinTemp.getStation());
            pstmt.setFloat(5, weatherWithMinTemp.getTemp());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatamartConnection.connect();
        createTable();
    }
}
