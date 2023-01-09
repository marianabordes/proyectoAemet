import com.google.gson.JsonElement;

public class WeatherDeserializer {

    public Weather getWeather (JsonElement weatherJsonObject) {

        Weather weather = new Weather();

        weather.setTimestamp(weatherJsonObject.getAsJsonObject().get("fint").getAsString());
        weather.setStation(weatherJsonObject.getAsJsonObject().get("idema").getAsString());
        weather.setPlace(weatherJsonObject.getAsJsonObject().get("ubi").getAsString());
        weather.setAirTemperature(weatherJsonObject.getAsJsonObject().get("ta").getAsFloat());
        weather.setAirTempMax(weatherJsonObject.getAsJsonObject().get("tamax").getAsFloat());
        weather.setAirTempMin(weatherJsonObject.getAsJsonObject().get("tamin").getAsFloat());
        weather.setLongi(weatherJsonObject.getAsJsonObject().get("lon").getAsFloat());
        weather.setLat(weatherJsonObject.getAsJsonObject().get("lat").getAsFloat());

        return weather;
    }
}
