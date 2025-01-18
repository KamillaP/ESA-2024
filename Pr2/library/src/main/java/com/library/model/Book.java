package com.library.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
