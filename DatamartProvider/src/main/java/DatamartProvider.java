import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatamartProvider {

    public static ArrayList<String> getInformation(File path) throws FileNotFoundException {
        // este método necesita el path para funcionar
        File[] listFiles = path.listFiles();
        ArrayList<String> jsons = new ArrayList<>();
        assert listFiles != null;
        for (File file : listFiles) {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                jsons.add(data);
            }
        }
        return jsons;
    }

    public static void setInformation(String json) throws SQLException {
        TableManager tableManager = new TableManager();
        DatamartConnection connection = new DatamartConnection();
        ArrayList<Weather> deserializedJson = WeatherDeserializer.jsonDeserializer(json);
        Weather highestTemp = TemperatureFilter.getHighestTemp(deserializedJson);
        System.out.println(highestTemp);
        tableManager.insertTempMax(highestTemp, connection);
        Weather lowestTemp = TemperatureFilter.getLowestTemp(deserializedJson);
        tableManager.insertTempMin(lowestTemp, connection);
    }
}
// "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake"
