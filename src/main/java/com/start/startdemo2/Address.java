package com.start.startdemo2;

public class Address {
    public String City;
    public String State;
    public Lines Lines;

    public com.start.startdemo2.Lines getLines() {
        return Lines;
    }

    public void setLines(com.start.startdemo2.Lines lines) {
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
