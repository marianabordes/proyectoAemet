package CONTROLLER;
import VIEW.AemetWeatherExtractor;
import VIEW.DataStorer;

import java.io.IOException;
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
                    AemetWeatherExtractor weatherExtractor = new AemetWeatherExtractor();
                    DataStorer dataStorer = new DataStorer();
                    List<MODEL.Weather> deserializedWeathers = weatherExtractor.getAemetWeathers();
                    List<MODEL.Weather> weathersToday = dataStorer.getWeathersFromGcToday(deserializedWeathers); // variable fileName ???
                    dataStorer.storeData(weathersToday);
                } catch (IOException e) {
                    //String msg = "RunTimeException";
                    //throw new WeatherException("msg");
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}
