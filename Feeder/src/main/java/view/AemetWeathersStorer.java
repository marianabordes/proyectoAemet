package view;

import model.*;
import com.google.gson.Gson;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AemetWeathersStorer {
    private String fileName = null;

    public void storeWeathersGcToday(List<Weather> weathersGcToday) throws IOException {
        FileWriter fileWriter;
        fileName = getFileName(weathersGcToday);
        File file = new File("datalake\\" + fileName + ".event");
        Set<Weather> contentInDatalake = getDatalakeContent();
        fileWriter = new FileWriter(file, true);
        for (Weather weather : weathersGcToday) {
            if (!contentInDatalake.contains(weather)) {
                fileWriter.write(new Gson().toJson(weather) + "\n");
            }
        }
        fileWriter.close();
    }

    private String getFileName(List<Weather> weathersGcToday) {
        fileName = weathersGcToday.get(0).getTimestamp().substring(0, 10).replace("-", "");
        return fileName;
    }

    private Set<Weather> getDatalakeContent() {
        Set<Weather> contentInDatalake = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datalake\\" + fileName + ".event"));
            String line;
            while ((line = reader.readLine()) != null) {
                Weather weather = new Gson().fromJson(line, Weather.class);
                contentInDatalake.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentInDatalake;
    }
}
