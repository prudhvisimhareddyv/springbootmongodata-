package com.start.startdemo2;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "CheckOutFinal")
public class CheckOutFinal {


    private String Username;
    private Map<String,Integer> Mco;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Map<String, Integer> getMco() {
        return Mco;
    }

    public void setMco(Map<String, Integer> mco) {
        Mco = mco;
    }
}
