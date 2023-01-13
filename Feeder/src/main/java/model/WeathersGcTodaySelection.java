package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeathersGcTodaySelection {
    public List<Weather> getWeathersFromGcToday(List<Weather> deserializedWeathers) {
        List<Weather> weathersFromGc = getWeathersGC(deserializedWeathers);
        ArrayList<Weather> weathersTodayGc = new ArrayList<>();
        for (Weather weather : weathersFromGc) {
            String weatherDate = weather.getTimestamp().substring(0, 10);
            if (weatherDate.equals(LocalDate.now().toString())) {
                weathersTodayGc.add(weather);
            }
        }
        return weathersTodayGc;
    }

    public List<Weather> getWeathersFromGcYesterday(List<Weather> deserializedWeathers) {
        List<Weather> weathersFromGc = getWeathersGC(deserializedWeathers);
        ArrayList<Weather> weathersTodayGc = new ArrayList<>();
        for (Weather weather : weathersFromGc) {
            String weatherDate = weather.getTimestamp().substring(0, 10);
            if (weatherDate.equals(LocalDate.now().toString())) {
                weathersTodayGc.add(weather);
            }
        }
        return weathersTodayGc;
    }

    public List<Weather> getWeathersGC(List<Weather> deserializedWeathers) {
        return deserializedWeathers.stream()
                .filter(w -> w.getLat() > 27.5 && w.getLat() < 28.4 && w.getLongi() > -16 && w.getLongi() < -15)
                .collect(Collectors.toList());
    }
}
