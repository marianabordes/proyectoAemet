public class Weather {
    private String date;
    private String time;
    private String place;
    private String station;
    private float temp;


    public Weather() {
    }

    public Weather(String date, String time, String place, String station, float temp) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.station = station;
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", station='" + station + '\'' +
                ", tempMax='" + temp + '\'' +
                '}';
    }
}

