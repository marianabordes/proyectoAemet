import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FeederController {
    public void control() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    String datosUrl = DataExtractor.getDataUrls();
                    String dataContent = DataExtractor.getData(datosUrl);
                    ArrayList<Weather> deserializedWeathers = DataManager.deserializeJson(dataContent);
                    List<Weather> weathersFromGC = DataManager.getWeathersGC(deserializedWeathers);
                    ArrayList<Weather> weathersToday = DataStorer.getWeathersFromDay(weathersFromGC); // variable fileName ???
                    DataStorer.storeData(weathersToday);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}
