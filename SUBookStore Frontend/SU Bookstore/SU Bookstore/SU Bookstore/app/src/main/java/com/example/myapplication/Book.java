package com.example.myapplication;


import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String year;
    private String price;
    private String author;
    private String image;
    private String category;
    private String publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book(String title, String year, String price, String author, String publisher, String category, String image) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
        this.image = image;
        this.category = category;
        this.publisher = publisher;
    }
}

