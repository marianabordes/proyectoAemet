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

    public Weather(String timestamp, String station, String place, float airTemperature, float airTempMax, float airTempMin, float longi, float lat) {
        this.timestamp = timestamp;
        this.station = station;
        this.place = place;
        this.airTemperature = airTemperature;
        this.airTempMax = airTempMax;
        this.airTempMin = airTempMin;
        this.longi = longi;
        this.lat = lat;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public float getAirTempMax() {
        return airTempMax;
    }

    public void setAirTempMax(float airTempMax) {
        this.airTempMax = airTempMax;
    }

    public float getAirTempMin() {
        return airTempMin;
    }

    public void setAirTempMin(float WeatherDeserializerairTempMin) {
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
        return "Weather{" +
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
}
