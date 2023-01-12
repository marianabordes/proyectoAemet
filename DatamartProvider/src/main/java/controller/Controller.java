package controller;

import model.*;
import view.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public void control(String pathDatamart, String pathDatalake) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    DatamartConnection.connect();
                    TableManager.createTable();
                    ArrayList<String> information = DatamartProvider.getInformation(new File("C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake")); // por que´no se ejecuta con pathDatalake
                    for (String json : information) {
                        DatamartProvider.setInformation(json, pathDatamart);
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
