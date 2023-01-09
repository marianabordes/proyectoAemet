import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManager {

    public List<Weather> filterData(String json) {

        ArrayList<Weather> weathersNotFiltered = new ArrayList<>();
        JsonArray events = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement event : events) {
            WeatherDeserializer deserializer = new WeatherDeserializer();
            Weather weather = deserializer.getWeather(event);
            weathersNotFiltered.add(weather);
        }

        List<Weather> weathers = weathersNotFiltered.stream()
                .filter(w -> w.getLat() > 27.5 && w.getLat() < 28.4 && w.getLongi() > -16 && w.getLongi() < -15)
                .collect(Collectors.toList());
        return weathers;
    }

    public void storeData(List<Weather> weathers) throws IOException {

        File archivo = null;
        FileWriter fileWriter = null;
        String fileName = null;
        ArrayList<Weather> weatherToday = new ArrayList<>();

        for (Weather weather : weathers) {
            String weatherDate = weather.getTimestamp().substring(0,10);

            if (weatherDate.equals(LocalDate.now().toString())){
                fileName = weatherDate.replace("-", "");
                weatherToday.add(weather);
            }
        }

        try{
            archivo = new File("datalake\\" + fileName + ".event");
            fileWriter = new FileWriter(archivo);
            fileWriter.write(new Gson().toJson(weatherToday));
            fileWriter.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
