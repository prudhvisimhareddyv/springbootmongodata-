package com.start.startdemo2;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Document(collection = "CheckOutFinal")
public class CheckOutFinal {


    private String Username;
    private Set<CheckOutFinal> ls;

    public Set<CheckOutFinal> getLs() {
        return ls;
    }

    public void setLs(Set<CheckOutFinal> ls) {
        this.ls = ls;
    }
// private Map<String,Integer> Mco;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

   /* public Map<String, Integer> getMco() {
        return Mco;
    }

    public void setMco(Map<String, Integer> mco) {
        Mco = mco;
    }*/
}
