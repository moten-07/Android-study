package com.example.class11;

public class book {
    private int bookimg;
    private String bookname;
    public book(int bookimg,String bookname){
        this.bookname=bookname;
        this.bookimg=bookimg;
    }

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
}
