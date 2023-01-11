import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManager {

    public static ArrayList<Weather> deserializeJson(String json) {

        ArrayList<Weather> deserializedWeathers = new ArrayList<>();
        JsonArray events = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement event : events) {
            Deserializer deserializer = new Deserializer();
            Weather weather = deserializer.getWeather(event);
            deserializedWeathers.add(weather);
        }
        return deserializedWeathers;
    }

    public static List<Weather> getWeathersGC(ArrayList<Weather> deserializedWeathers) {
        List<Weather> weathersFromGC = deserializedWeathers.stream()
                .filter(w -> w.getLat() > 27.5 && w.getLat() < 28.4 && w.getLongi() > -16 && w.getLongi() < -15)
                .collect(Collectors.toList());
        return weathersFromGC;
    }
}
