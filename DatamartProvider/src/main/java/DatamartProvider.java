import com.google.gson.Gson;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatamartProvider {

    public static void getJson(String path) throws IOException {
        try {
            File event = new File(path);
            Scanner myReader = new Scanner(event);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DatamartProvider.getJson("C:\\Users\\maria\\Desktop\\DACD\\proyectoAemet\\datalake\\20230109.event");
    }
}
