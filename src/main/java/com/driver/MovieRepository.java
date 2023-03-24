package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private Map<String, Movie> movieMap = new HashMap<>();

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public Movie getMovieByName(String name) {
        return movieMap.get(name);
    }

    public List<String> getAllMovieNames() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteAllDirectorsMovies(Director director) {
        Iterator<Map.Entry<String, Movie>> iterator = movieMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Movie> entry = iterator.next();
            if (entry.getValue().getDirector().equals(director)) {
                iterator.remove();
            }
        }
    }

    public void deleteMovie(Movie movie) {
        movieMap.remove(movie.getName());
    }
}

