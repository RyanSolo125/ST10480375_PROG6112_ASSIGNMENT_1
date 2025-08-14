package org.example;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    ///constuctor for book details
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }


    /// getters for book details
    public int getId() {
        return id; }

    public String getTitle() {
        return title; }

    public String getAuthor() {
        return author; }

    public boolean isAvailable() {
        return available; }

    public void setAvailable(boolean available) {
        this.available = available; }


    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author + (available ? " (Available)" : " (Borrowed)");
    }
}
