package model;

import java.util.Objects;

public class Weather {
    private String timestamp;
    private String station;
    private String place;
    private float airTemperature;
    private float airTempMax;
    private float airTempMin;
    private float longi;
    private float lat;

    public Weather() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setAirTemperature(float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public void setAirTempMax(float airTempMax) {
        this.airTempMax = airTempMax;
    }

    public void setAirTempMin(float airTempMin) {
        this.airTempMin = airTempMin;
    }

    public float getLongi() {
        return longi;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "MODEL.Weather{" +
                "timestamp='" + timestamp + '\'' +
                ", station='" + station + '\'' +
                ", place='" + place + '\'' +
                ", airTemperature=" + airTemperature +
                ", airTempMax=" + airTempMax +
                ", airTempMin=" + airTempMin +
                ", longi=" + longi +
                ", lat=" + lat +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Weather weather) {
            return Objects.equals(this.station, weather.station) && Objects.equals(this.timestamp, weather.timestamp);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.station.hashCode() + this.timestamp.hashCode();
    }
}
