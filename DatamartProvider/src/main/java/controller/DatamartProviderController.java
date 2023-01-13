package controller;

import model.DatamartConnection;
import model.TableManager;
import model.Weather;
import view.DatamartProvider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DatamartProviderController {
    public void control() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DatamartConnection connection = new DatamartConnection();
                DatamartProvider datamartProvider = new DatamartProvider();
                TableManager tables = new TableManager();
                try {
                    connection.connect();
                    tables.createTable();
                    ArrayList<Weather> jsonsFromDatalake = datamartProvider.getWeathersFromDatalake();
                    datamartProvider.setFilteredWeathersInDatamart(jsonsFromDatalake, tables, connection);
                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, 60000, 3600000);
    }
}
