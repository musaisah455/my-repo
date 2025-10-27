package com.code.myapps.mybook.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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

}
