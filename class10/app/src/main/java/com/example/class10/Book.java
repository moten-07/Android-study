package com.example.class10;

public class Book {
    private int bookimg;
    private String bookname;

    public int getBookimg() {
        return bookimg;
    }

    public void setBookimg(int bookimg) {
        this.bookimg = bookimg;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Book(int bookimg, String bookname){
        this.bookimg=bookimg;
        this.bookname=bookname;
    }
}
