package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.*;

@Entity
@Table(name="vpru")
public class Vpru {
    @Id
   @Column(name = "cvrey_id")
    private Integer CvreyID;
    @Column(name="last_name")
    private String LastName;
    @Column(name="first_name")
    private String FirstName;
    @Column(name = "address")
    private String Address;
    @Column(name = "city")
    private String City;

    public Integer getCvreyID() {
        return CvreyID;
    }

    public void setCvreyID(int cvreyID) {
        CvreyID = cvreyID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
