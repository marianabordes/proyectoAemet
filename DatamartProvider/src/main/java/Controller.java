import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    DatamartConnection.connect();
                    TableManager.createTable();
                    ArrayList<String> information = DatamartProvider.getInformation(new File("C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake"));
                    for (String json : information) {
                        DatamartProvider.setInformation(json);
                    }
                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}
