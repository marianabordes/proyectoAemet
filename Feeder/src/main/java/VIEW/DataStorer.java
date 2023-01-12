package VIEW;

import MODEL.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorer {
    public File file = null;
    public FileWriter fileWriter = null;
    public String fileName = null;

    public void storeData(List<Weather> weathersToday) throws IOException {
        try {
            file = new File("datalake\\" + fileName + ".event");
            fileWriter = new FileWriter(file);
            fileWriter.write(new Gson().toJson(weathersToday));
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } public List<Weather> getWeathersFromGcToday(List<Weather> deserializedWeathers) {
        List<Weather> weathersFromGc = getWeathersGC(deserializedWeathers);
        ArrayList<Weather> weathersTodayGc = new ArrayList<>();
        for (Weather weather : weathersFromGc) {
            String weatherDate = weather.getTimestamp().substring(0, 10);
            if (weatherDate.equals(LocalDate.now().toString())) {
                fileName = weatherDate.replace("-", "");
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
