package view;

import model.*;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorer {
    public File file = null;
    public FileWriter fileWriter = null;
    public FileReader fileReader = null;
    public BufferedReader bufferedReader = null;
    public String fileName = null;

    public void storeData(List<Weather> weathersToday) throws IOException {
        file = new File("datalake\\" + fileName + ".event");
        fileWriter = new FileWriter(file, true);
        for (Weather weather : weathersToday) {
            fileWriter.write(new Gson().toJson(weathersToday));
        }
        fileWriter.close();
    }

    public void isInDatalake() throws IOException {
        file = new File("C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void main(String[] args) throws IOException {
        DataStorer storer = new DataStorer();
        storer.isInDatalake();

    }

    public List<Weather> getWeathersFromGcToday(List<Weather> deserializedWeathers) {
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
