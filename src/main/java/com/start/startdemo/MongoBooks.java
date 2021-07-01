package com.start.startdemo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Document(collection = "Books")
public class MongoBooks {

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    private int price;

    @Id
    private int  _id;

    private String bookname;
}
