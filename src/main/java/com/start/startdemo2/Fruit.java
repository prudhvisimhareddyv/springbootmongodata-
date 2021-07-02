package com.start.startdemo2;

public class Fruit {
    private String name;
    private int quantity;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fruit) {
            return ((Fruit) obj).quantity == quantity && ((Fruit) obj).name.contentEquals(name);
        }

        return false;
    }


    @Override
    public int hashCode() {

        return this.id;
    }
}
