import controller.FeederController;

public class MainFD {
    public static void main(String[] args) {
        FeederController controller = new FeederController();
        String apiKey = args[0];
        controller.control(apiKey);
    }
}
