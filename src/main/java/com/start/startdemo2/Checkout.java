package com.start.startdemo2;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


public class Checkout {


    private String productnames;




    public String getProductnames() {
        return productnames;
    }

    public void setProductnames(String productnames) {
        this.productnames = productnames;
    }


}
