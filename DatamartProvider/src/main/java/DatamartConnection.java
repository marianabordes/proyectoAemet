import java.sql.*;

public class DatamartConnection {
    private Connection connection;

    public DatamartConnection (){ this.connection = connect(); }
    public Connection getConnection() { return connection; }

    public static Connection connect() {
        Connection connection = null;
        try {
            String path = "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datamart.db";    // hacer con la ruta relativa o pasar la ruta como arg de la app
            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
            System.out.println("todo guay");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Algo ha salido mal");
        }
        return connection;
    }
}
