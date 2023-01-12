package model;

import java.util.ArrayList;
import java.util.Comparator;

public class TemperatureFilter {
    public static Weather getHighestTemp(ArrayList<Weather> mylist) {
        Weather highestTemp = mylist.stream().max(Comparator.comparing(Weather::getTemp)).get();
        System.out.println();
        return highestTemp;
    }

    public static Weather getLowestTemp(ArrayList<Weather> mylist) {
        Weather highestTemp = mylist.stream().min(Comparator.comparing(Weather::getTemp)).get();
        System.out.println();
        return highestTemp;
    }
}
