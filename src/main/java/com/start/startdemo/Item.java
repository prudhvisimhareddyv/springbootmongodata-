package com.start.startdemo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="item")
public class Item {
    private String item;
    private int qty;
    private String[] tags= new String[5];
    private float[] dim_cm =new float[5];

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public float[] getDim_cm() {
        return dim_cm;
    }

    public void setDim_cm(float[] dim_cm) {
        this.dim_cm = dim_cm;
    }
}
