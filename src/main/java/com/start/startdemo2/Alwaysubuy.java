package com.start.startdemo2;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

@Document(collection = "Alwaysubuy")
public class Alwaysubuy{
    @Id
    private int  _id;
    private String productname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alwaysubuy that = (Alwaysubuy) o;
        return _id == that._id || Objects.equals(productname, that.productname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, productname);
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }


}
