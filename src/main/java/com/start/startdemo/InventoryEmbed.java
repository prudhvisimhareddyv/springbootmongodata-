package com.start.startdemo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="InventoryEmbed")
public class InventoryEmbed {
    private String item;
    private List<Instock>  instock;

    public List<Instock> getInstock() {
        return instock;
    }

    public void setInstock(List<Instock> instock) {
        this.instock = instock;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
