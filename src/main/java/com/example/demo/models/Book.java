package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Double amazonRating;
    private String description;
    private String imageUrl;
    private String genre;

    // No-arg constructor required by JPA
    public Book() {}

    // All-args constructor
    public Book(Long id, String title, String author, Double amazonRating, String description, String imageUrl, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amazonRating = amazonRating;
        this.description = description;
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Double getAmazonRating() { return amazonRating; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getGenre() { return genre; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setAmazonRating(Double amazonRating) { this.amazonRating = amazonRating; }
    public void setDescription(String description) { this.description = description; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setGenre(String genre) { this.genre = genre; }
}
