import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class TemperatureProvider {

    private List<Weather> weathers;

    public TemperatureProvider (){
        weathers = new ArrayList<>();
    };

    public List<Weather> searchAll() {
        return weathers;
    }

    public Weather getMaxTemp(String date1, String date2) throws ParseException {
        ArrayList<Weather> weathersInRangeWithMaxTemp = new ArrayList<>();
        for (Weather weather : weathers) {
            if(isInRange(weather, date1, date2)){
                return weather;
            }
        }
    }

    public static boolean isInRange(Weather weather, String startDate, String endDate) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1Date = simpleFormat.parse(startDate);
        Date date2Date = simpleFormat.parse(endDate);
        Date dateWeatherDate = simpleFormat.parse(weather.getDate());
        return dateWeatherDate.after(date1Date) && dateWeatherDate.before(date2Date);
    }
}
