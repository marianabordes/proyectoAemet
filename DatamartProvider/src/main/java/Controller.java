import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        DatamartConnection connection = new DatamartConnection();
        DatamartConnection.connect();
        TableManager tableManager = new TableManager();
        TableManager.createTable();
        ArrayList<String> information = DatamartProvider.getInformation(new File("C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake"));
        for (String json : information) {
            DatamartProvider.setInformation(json);
        }
    }

}
