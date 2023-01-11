import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataStorer {
    public static File file = null;
    public static FileWriter fileWriter = null;
    public static String fileName = null;

    public static ArrayList<Weather> getWeathersFromDay(List<Weather> weathersFromGC) {

        ArrayList<Weather> weathersToday = new ArrayList<>();

        for (Weather weather : weathersFromGC) {
            String weatherDate = weather.getTimestamp().substring(0, 10);

            if (weatherDate.equals(LocalDate.now().toString())) {
                fileName = weatherDate.replace("-", "");
                weathersToday.add(weather);
            }
        }
        return weathersToday;
    }

    public static void storeData(ArrayList<Weather> weathersToday) throws IOException {
        try {
            file = new File("datalake\\" + fileName + ".event");
            fileWriter = new FileWriter(file);
            fileWriter.write(new Gson().toJson(weathersToday));
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
