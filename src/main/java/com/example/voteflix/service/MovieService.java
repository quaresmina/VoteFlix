package com.example.voteflix.service;

import com.example.voteflix.model.Movie;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie updateMovie(Movie movie) throws DataAccessException;
}
