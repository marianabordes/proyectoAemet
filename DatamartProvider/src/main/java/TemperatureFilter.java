import java.util.ArrayList;
import java.util.Comparator;

public class TemperatureFilter {
   /* public static Weather getHighestTemp(ArrayList<Weather> myList) {
        double minTemp = myList.get(0).getTemp();
        for (Weather weather : myList) {
            if (weather.getTemp() > minTemp) {
                minTemp = weather.getTemp();
            }
        }
        return highestTemp;
    }*/

    public static Weather getHighestTemp(ArrayList<Weather> mylist) {
        Weather highestTemp = mylist.stream().max(Comparator.comparing(Weather::getTemp)).get();
        System.out.println();
        return highestTemp;
    }

    /*public static Weather getLowestTemp(ArrayList<Weather> myList) {
        Weather lowestTemp = new Weather();
        double maxTemp = myList.get(0).getTemp();
        for (Weather weather : myList) {
            if (weather.getTemp() < maxTemp && weather.getTemp() != 0) {
                lowestTemp = weather;
            }
        }
        return lowestTemp;
    }*/

    public static Weather getLowestTemp(ArrayList<Weather> mylist) {
        Weather highestTemp = mylist.stream().min(Comparator.comparing(Weather::getTemp)).get();
        System.out.println();
        return highestTemp;
    }
}
