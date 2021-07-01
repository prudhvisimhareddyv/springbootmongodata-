package com.start.startdemo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection="City")
public class City {
    @Id
    private int _id;
    private int zipcode;
    private String cityname;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) {
            return ((City) obj).zipcode == zipcode && ((City) obj).cityname.contentEquals(cityname) && ((City) obj)._id == _id;
        }

        return false;
    }


    @Override
    public int hashCode() {

        return this._id;
    }

}
