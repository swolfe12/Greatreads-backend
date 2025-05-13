package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "Books")
public class Book {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private Double rating;
    
    // No-arg constructor required by JPA
    public Book() {}
    
    // Constructor with all fields
    public Book(Long id, String name, String description, Double rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getRating() { return rating; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setRating(Double rating) { this.rating = rating; }
}