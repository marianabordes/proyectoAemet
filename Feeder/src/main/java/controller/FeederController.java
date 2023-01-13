package controller;

import model.WeathersGcTodaySelection;
import view.AemetWeatherExtractor;
import view.DataStorer;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FeederController {
    public void control(String apiKey) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    AemetWeatherExtractor weatherExtractor = new AemetWeatherExtractor();
                    DataStorer dataStorer = new DataStorer();
                    WeathersGcTodaySelection selection = new WeathersGcTodaySelection();
                    List<model.Weather> deserializedWeathers = weatherExtractor.getAemetWeathers(apiKey);
                    List<model.Weather> weathersGcToday = selection.getWeathersFromGcToday(deserializedWeathers);
                    dataStorer.storeWeathersGcToday(weathersGcToday);
                } catch (IOException ignored) {
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}
