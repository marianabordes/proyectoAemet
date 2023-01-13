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
    public void control() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    DatamartConnection.connect();
                    TableManager.createTable();
                    ArrayList<String> information = DatamartProvider.getInformation(new File("datalake\\")); // por que´no se ejecuta con pathDatalake
                    ArrayList<String> strings = DatamartProvider.setinfo(information);
                    for (String informationOfDay : strings) {
                        WeatherDeserializer.jsonDeserializer(informationOfDay);
                    }
                } catch (Exception  e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");

            }
        };
        timer.scheduleAtFixedRate(task, 0, 3600000);
    }
}

