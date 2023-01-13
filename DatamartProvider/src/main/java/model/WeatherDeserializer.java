package model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class WeatherDeserializer {

    public static Weather getWeather(JsonElement weatherJsonObject) {

        Weather weather = new Weather();

        weather.setDate(weatherJsonObject.getAsJsonObject().get("timestamp").getAsString().substring(0, 10));
        weather.setTime(weatherJsonObject.getAsJsonObject().get("timestamp").getAsString().substring(11));
        weather.setStation(weatherJsonObject.getAsJsonObject().get("station").getAsString());
        weather.setPlace(weatherJsonObject.getAsJsonObject().get("place").getAsString());
        if (weatherJsonObject.getAsJsonObject().get("airTemperature").getAsDouble() != 0) {
            weather.setTemp(weatherJsonObject.getAsJsonObject().get("airTemperature").getAsDouble());
        } else {return null;}
        return weather;
    }

    public static ArrayList<Weather> jsonDeserializer(String json) {
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        ArrayList<Weather> jsonElements = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            Weather weatherInJson = getWeather(element);
            if (weatherInJson != null)
                jsonElements.add(weatherInJson);
        }
        return jsonElements;
    }
}
