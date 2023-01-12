package model;

public class WeatherException extends Exception{
    private String msg;
    public WeatherException (String msg) {
        super();
        this.msg = msg;
    }
}
