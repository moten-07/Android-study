package com.example.class27;

public class weather {  // 与json数据对应的类
    private String temp;
    private String weather;
    private String name;
    private String pm;
    private String wind;

    public weather(String temp,String weather,String name,String pm,String wind){
        this.temp=temp;
        this.weather=weather;
        this.name=name;
        this.pm=pm;
        this.wind=wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
