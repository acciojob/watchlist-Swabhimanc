package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public List<String> getAllMovieNames() {
        return movieRepository.getAllMovieNames();
    }

    public void deleteAllDirectorsMovies(Director director) {
        movieRepository.deleteAllDirectorsMovies(director);
    }

    public void deleteMovie(Movie movie) {
        movieRepository.deleteMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

}

