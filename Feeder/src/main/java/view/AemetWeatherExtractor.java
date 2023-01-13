package view;

import model.Deserializer;
import model.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AemetWeatherExtractor {

    public List<Weather> getAemetWeathers(String apiKey) throws IOException {
        String dataUrl = "https://opendata.aemet.es/opendata/api/observacion/convencional/todas";
       // String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYW5hLmJvcmRlczEwMUBhbHUudWxwZ2MuZXMiLCJqdGkiOiIwYjE1YmU1OC0zNGQ2LTQxZGMtYmMwMS00OWI4NmU0ZjFmOTciLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3MjI0MzM3OSwidXNlcklkIjoiMGIxNWJlNTgtMzRkNi00MWRjLWJjMDEtNDliODZlNGYxZjk3Iiwicm9sZSI6IiJ9.IJ-zH2SJWP5xcOsjVWLJ9hQ15zhfuscrpXaaDf3qJFk";
        String datosUrl = getDataUrls(dataUrl, apiKey);
        String dataContent = getData(datosUrl);
        return deserializeJson(dataContent); // returns deserialized weathers
    }

    private String getDataUrls(String dataUrl, String apiKey) throws IOException {
        String jsonResponse = Jsoup.connect(dataUrl)
                .validateTLSCertificates(false)
                .timeout(10000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .header("api_key", apiKey)
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);
        return jsonObject.get("datos").getAsString();
    }

    private String getData(String datosUrl) throws IOException {
        return Jsoup.connect(datosUrl)
                .validateTLSCertificates(false)
                .timeout(20000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }

    private List<Weather> deserializeJson(String json) {
        ArrayList<Weather> deserializedWeathers = new ArrayList<>();
        JsonArray events = new Gson().fromJson(json, JsonArray.class);
        for (JsonElement event : events) {
            Deserializer deserializer = new Deserializer();
            Weather weather = deserializer.getWeather(event);
            deserializedWeathers.add(weather);
        }
        return deserializedWeathers;
    }
}
