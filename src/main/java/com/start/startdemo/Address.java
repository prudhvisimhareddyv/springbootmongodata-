package com.start.startdemo;

public class Address {
    public String City;
    public String State;
    public Lines Lines;

    public com.start.startdemo.Lines getLines() {
        return Lines;
    }

    public void setLines(com.start.startdemo.Lines lines) {
        Lines = lines;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
