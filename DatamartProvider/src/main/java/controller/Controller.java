package controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
                    ArrayList<JsonObject> information = DatamartProvider.getInformation(); // por que´no se ejecuta con pathDatalake
                    DatamartProvider.setInformation(information);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ejecutado correctamente");
            }
        };
        timer.scheduleAtFixedRate(task, /*60000,*/ 0,  3600000);
    }
}
