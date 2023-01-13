package view;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.*;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DatamartProvider {

    public static ArrayList<JsonObject> getInformation() throws FileNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMDD");
        String fileName = formatter.format(LocalDate.now()) + ".event";
        File file = new File(".\\datalake\\" + fileName);
        ArrayList<JsonObject> jsons = new ArrayList<>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            JsonObject dataJsonObject = new Gson().fromJson(data, JsonObject.class);
            jsons.add(dataJsonObject);
        }
        System.out.println(jsons);
        return jsons;
    }

    public static void setInformation(ArrayList<JsonObject> information) throws SQLException {
        TableManager tableManager = new TableManager();
        DatamartConnection connection = new DatamartConnection();
        ArrayList<Weather> deserializedJson = WeatherDeserializer.jsonDeserializer(information);
        Weather highestTemp = TemperatureFilter.getHighestTemp(deserializedJson);
        Weather lowestTemp = TemperatureFilter.getLowestTemp(deserializedJson);
        tableManager.insertTempMax(highestTemp, connection);
        tableManager.insertTempMin(lowestTemp, connection);
    }
}
// "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake"
