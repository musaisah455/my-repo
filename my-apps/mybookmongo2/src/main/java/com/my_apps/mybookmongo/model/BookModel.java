package com.my_apps.mybookmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "book")
public class BookModel {

    // Define the sequence name
    public static final String SEQUENCE_NAME = "book_sequence";

    @Id
    private Long id;
    //@Column(name = "title")
    private String title;
    //@Column(name ="author")
    private String author;
    //@Column(name ="isbn")
    private String isbn;
    //@Column(name ="price")
    private double price;
}


