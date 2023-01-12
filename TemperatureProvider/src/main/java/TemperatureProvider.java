import java.util.ArrayList;
import java.util.List;

public class TemperatureProvider {

    private List<Weather> weathers;

    public TemperatureProvider() {
        weathers = new ArrayList<>();
    }

    ;

    public List<Weather> searchAll() {
        return weathers;
    }


}
