package com.start.startdemo;

public class Iphone {
    private int iphone;
    private String colour;
    private String colour1;

    public Iphone(int iphone, String colour, String colour1) {
        this.iphone = iphone;
        this.colour = colour;
        this.colour1 = colour1;
    }

    public String getColour1() {
        return colour1;
    }

    public void setColour1(String colour1) {
        this.colour1 = colour1;
    }

    public int getIphone() {
        return iphone;
    }

    public void setIphone(int iphone) {
        this.iphone = iphone;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Iphone) {
            return ((Iphone) obj).iphone == iphone;
        }
        return false;
    }

     @Override
    public int hashCode() {
        return this.iphone;
    }
}
