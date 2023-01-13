package model;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Deserializer {
    public ArrayList<Weather> jsonDeserializer(ArrayList<JsonObject> jsons) {
        ArrayList<Weather> jsonElements = new ArrayList<>();
        for (JsonElement json : jsons) {
            Weather weatherInJson = getWeather(json);
            if (weatherInJson != null)
                jsonElements.add(weatherInJson);
        }
        return jsonElements;
    }

    private Weather getWeather(JsonElement weatherJsonObject) {
        Weather weather = new Weather();
        weather.setDate(weatherJsonObject.getAsJsonObject().get("timestamp").getAsString().substring(0, 10));
        weather.setTime(weatherJsonObject.getAsJsonObject().get("timestamp").getAsString().substring(11));
        weather.setStation(weatherJsonObject.getAsJsonObject().get("station").getAsString());
        weather.setPlace(weatherJsonObject.getAsJsonObject().get("place").getAsString());
        if (weatherJsonObject.getAsJsonObject().get("airTemperature").getAsDouble() != 0) {
            weather.setTemp(weatherJsonObject.getAsJsonObject().get("airTemperature").getAsDouble());
        } else {
            return null;
        }
        return weather;
    }
}
