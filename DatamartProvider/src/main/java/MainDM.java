import controller.Controller;

public class MainDM {
    public static void main(String[] args) {
        String pathDatalake = args[0];
        String pathDatamart = args[1];
        Controller controller = new Controller();
        controller.control(pathDatalake, pathDatamart);
    }
}
