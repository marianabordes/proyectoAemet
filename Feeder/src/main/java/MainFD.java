import controller.FeederController;
import model.WeatherException;

public class MainFD {
    public static void main(String[] args) throws WeatherException {
        FeederController controller = new FeederController();
        controller.control();
    }
}
