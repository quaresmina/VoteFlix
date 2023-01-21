package com.example.voteflix.controller;

import com.example.voteflix.model.Movie;
import com.example.voteflix.repository.MovieRepository;
import com.example.voteflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<Movie> registerMovie(@RequestBody Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.movieRepository.save(movie), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Movie> findMovie(@PathVariable Long id){
        Optional<Movie> movieReturn = this.movieRepository.findById(id);

        if (movieReturn.isEmpty()){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(this.movieRepository.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<Movie>> findAllMovies(){
        Movie movie1 = new Movie("Jornada nas estrelas", 1992, "Shakespeare");
        System.out.println(movie1.toString());
        this.movieRepository.save(movie1);

        return new ResponseEntity<>(this.movieRepository.findAll(), HttpStatus.OK);
    }
}
