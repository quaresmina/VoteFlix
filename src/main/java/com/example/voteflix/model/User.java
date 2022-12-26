package com.example.voteflix.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    private String email;
    public List<Movie> watchedMovies = new ArrayList<>();
    public List<Movie> wishListMovies = new ArrayList<>();
}
