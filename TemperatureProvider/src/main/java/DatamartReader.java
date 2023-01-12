import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatamartReader {

    private Connection connect(String path) {
        String url = "jdbc:sqlite:" + path;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Weather> selectWeathersInRangeMaxTemp(String date1, String date2, String path){
        String sql = "SELECT date, place, temp FROM tempMax";
        List<Weather> weathers = new ArrayList<>();

        try (Connection conn = this.connect(path);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                filterWeathers(date1, date2, weathers, rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return weathers;
    }

    public List<Weather> selectWeathersInRangeMinTemp(String date1, String date2, String path){
        String sql = "SELECT date, place, temp FROM tempMin";
        List<Weather> weathers = new ArrayList<>();

        try (Connection conn = this.connect(path);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                filterWeathers(date1, date2, weathers, rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return weathers;
    }

    private static void filterWeathers(String date1, String date2, List<Weather> weathers, ResultSet rs) throws SQLException, ParseException {
        Weather weather = new Weather();
        weather.setDate(rs.getString("date"));
        weather.setPlace(rs.getString("place"));
        weather.setTemp(rs.getDouble("temp"));
        if (isInRange(weather, date1, date2))
            weathers.add(weather);
    }


    public static boolean isInRange(Weather weather, String startDate, String endDate) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1Date = simpleFormat.parse(startDate);
        Date date2Date = simpleFormat.parse(endDate);
        Date dateWeatherDate = simpleFormat.parse(weather.getDate());
        return dateWeatherDate.after(date1Date) || dateWeatherDate.before(date2Date);
    }
}
