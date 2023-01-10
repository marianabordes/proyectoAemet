import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FeederController {
    public void controlWithTimerTask() throws IOException {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DataManager dataManager = new DataManager();
                String datos = null;

                try {
                    datos = DataExtractor.getDataUrls();
                    String json = DataExtractor.getData(datos);
                    List<Weather> weathers = dataManager.filterData(json);
                    dataManager.storeData(weathers);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }

    public void control() throws IOException {

        DataManager dataManager = new DataManager();
        String datos = null;

        datos = DataExtractor.getDataUrls();
        String json = DataExtractor.getData(datos);
        List<Weather> weathers = dataManager.filterData(json);
        dataManager.storeData(weathers);
    }
}
