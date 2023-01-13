package model;

public class Weather {
    private String date;
    private String time;
    private String place;
    private double temp;

    public Weather() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "model.Weather{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", tempMax='" + temp + '\'' +
                '}';
    }
}

