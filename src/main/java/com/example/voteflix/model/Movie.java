package com.example.voteflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public int releaseYear;
    public String authorName;
    public int rating;

    public Movie(){

    }

    public Movie(String title, int releaseYear, String authorName){
        this.title = title;
        this.releaseYear = releaseYear;
        this.authorName = authorName;
    }

}
