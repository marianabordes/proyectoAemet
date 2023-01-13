package view;

import model.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatamartProvider {

    public static ArrayList<String> getInformation(File path) throws FileNotFoundException {
        // este método necesita el path para funcionar
        //File file = new File(pathDatalake);
        File[] listFiles = path.listFiles();
        ArrayList<String> jsons = new ArrayList<>();
        assert listFiles != null;
        for (File fileInLIst : listFiles) {
            Scanner myReader = new Scanner(fileInLIst);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                jsons.add(data);
            }
        }
        return jsons; //cada item de jsons equivale a la información de un fichero
    }

    public static void setInformation(String json, String pathDatamart) throws SQLException {
        TableManager tableManager = new TableManager();
        DatamartConnection connection = new DatamartConnection();
        ArrayList<Weather> deserializedJson = WeatherDeserializer.jsonDeserializer(json);
        Weather highestTemp = TemperatureFilter.getHighestTemp(deserializedJson);
        Weather lowestTemp = TemperatureFilter.getLowestTemp(deserializedJson);
        tableManager.insertTempMax(highestTemp, connection);
        tableManager.insertTempMin(lowestTemp, connection);
    }

    public static ArrayList<String> setinfo(ArrayList<String> json) {
        //String[] strings = json.toArray(new String[0]);
        ArrayList<String> strings = new ArrayList<>();
        for (String item : json){
            strings.add(Arrays.toString(item.split("\n")));
        }
        System.out.println(strings);
        //String[] strings =  json.split("\n");
       // System.out.println(strings);
        return strings;
    }
}
// "C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake"
