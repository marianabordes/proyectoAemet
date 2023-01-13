package view;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DatamartProvider {

    public ArrayList<Weather> getWeathersFromDatalake() throws FileNotFoundException {
        WeatherDeserializer deserializer = new WeatherDeserializer();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fileName = formatter.format(LocalDate.now()) + ".event";
        File file = new File(".\\datalake\\" + fileName);
        ArrayList<JsonObject> jsonsInDatalake = new ArrayList<>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            JsonObject dataJsonObject = new Gson().fromJson(data, JsonObject.class);
            jsonsInDatalake.add(dataJsonObject);
        }
        return deserializer.jsonDeserializer(jsonsInDatalake);
    }

    public void setFilteredWeathersInDatamart(ArrayList<Weather> jsonsFromDatalake, TableManager tableManager, DatamartConnection connection) throws SQLException {
        TemperatureFilter filter = new TemperatureFilter();
        Weather highestTemp = filter.getHighestTemp(jsonsFromDatalake);
        Weather lowestTemp = filter.getLowestTemp(jsonsFromDatalake);
        tableManager.insertTempMax(highestTemp, connection);
        tableManager.insertTempMin(lowestTemp, connection);
    }
}
