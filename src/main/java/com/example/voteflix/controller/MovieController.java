package com.example.voteflix.controller;

import com.example.voteflix.model.Movie;
import com.example.voteflix.repository.MovieRepository;
import com.example.voteflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping("/findMovie")
    public ResponseEntity<Movie> findMovie(@RequestBody Long id, BindingResult bindingResult){
        Optional<Movie> movieReturn = this.movieRepository.findById(id);

        if(bindingResult.hasErrors() || movieReturn.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.movieRepository.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/findAllMovies")
    public ResponseEntity<List<Movie>> findAllMovies(@RequestBody BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.movieRepository.findAll(), HttpStatus.OK);
    }
}
