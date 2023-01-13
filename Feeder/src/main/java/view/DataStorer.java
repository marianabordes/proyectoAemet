package view;

import model.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataStorer {
    public File file = null;
    public FileWriter fileWriter = null;
    public String fileName = null;

    public void storeData(List<Weather> weathersToday) throws IOException {
        fileName = getFileName(weathersToday);
        file = new File("datalake\\" + fileName + ".event");
        Set<Weather> datalakeContent = readDatalake();
        fileWriter = new FileWriter(file, true);
        for (Weather weather : weathersToday) {
            if(!datalakeContent.contains(weather)){
                fileWriter.write(new Gson().toJson(weather) + "\n");
            }
        }
        fileWriter.close();
    }


    public String getFileName(List<Weather> weathersToday) {
        fileName = weathersToday.get(0).getTimestamp().substring(0, 10).replace("-", "");
        return fileName;
    }

    public Set<Weather> readDatalake() {
        Set<Weather> datalakeContent = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datalake\\" + fileName + ".event"));
            String line;
            while ((line = reader.readLine()) != null) {
                Weather weather = new Gson().fromJson(line, Weather.class);
                datalakeContent.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datalakeContent;
    }
}
