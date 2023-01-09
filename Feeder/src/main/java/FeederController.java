import java.io.IOException;
import java.util.List;

public class FeederController {
    public static void main(String[] args) throws IOException {
        controller();
    }
    public static void controller() throws IOException {
        DataManager dataManager = new DataManager();

        String datos = DataExtractor.getDataUrls();
        String json = DataExtractor.getData(datos);
        List<Weather> weathers = dataManager.filterData(json);
        dataManager.storeData(weathers);

    }
}
