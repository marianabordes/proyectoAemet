package model;

public class Weather {
    private String date;
    private String time;
    private String place;
    private String station;
    private double temp;


    public Weather() {
    }

    public Weather(String date, String time, String place, String station, double temp) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.station = station;
        this.temp = temp;
    } // Debería poner el constructor en la clase POJO si no se utiliza nunca?

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

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "MODEL.Weather{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", station='" + station + '\'' +
                ", tempMax='" + temp + '\'' +
                '}';
    }
}

