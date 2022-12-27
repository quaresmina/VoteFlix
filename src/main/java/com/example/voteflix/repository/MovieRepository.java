package com.example.voteflix.repository;

import com.example.voteflix.model.Movie;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

   Movie save(Movie movie) throws DataAccessException;
   List<Movie> findAll();
   Optional<Movie> findById(Long id);
}
