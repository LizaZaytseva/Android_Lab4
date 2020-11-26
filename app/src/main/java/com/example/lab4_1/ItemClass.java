package com.example.lab4_1;

public class ItemClass {
   private String author, title, journal, year, pages;
    public void item (String author, String title, String journal, String year, String pages){
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.pages = pages;
    }
    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getJournal() {
        return this.journal;
    }

    public String getYear() {
        return this.year;
    }

    public String getPages() {
        return this.pages;
    }

}
