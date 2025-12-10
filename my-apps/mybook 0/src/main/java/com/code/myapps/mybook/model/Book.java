package com.code.myapps.mybook.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="book_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name ="author")
    private String author;
    @Column(name ="isbn")
    private String isbn;
    @Column(name ="price")
    private double price;

    public Book() {

    }

    public Book(String title, String author, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
