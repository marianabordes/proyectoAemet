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
            String path = "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datamart.db";    // hacer con la ruta relativa o pasar la ruta como arg de la app
            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
