import CONTROLLER.FeederController;
import MODEL.WeatherException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws WeatherException {
        FeederController controller = new FeederController();
        controller.control();
    }
}
