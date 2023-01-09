import com.google.gson.JsonElement;

public class WeatherDeserializer {

    public Weather getWeather (JsonElement weatherJsonObject) {

        Weather weather = new Weather();

        weather.setDate(weatherJsonObject.getAsJsonObject().get("fint").getAsString().substring(0, 10));
        weather.setTime(weatherJsonObject.getAsJsonObject().get("fint").getAsString().substring(11));
        weather.setStation(weatherJsonObject.getAsJsonObject().get("idema").getAsString());
        weather.setPlace(weatherJsonObject.getAsJsonObject().get("ubi").getAsString());
        try{
            weather.setTemp(weatherJsonObject.getAsJsonObject().get("ta").getAsFloat());
        } catch (Exception ignored) {}

        return weather;
    }
}
