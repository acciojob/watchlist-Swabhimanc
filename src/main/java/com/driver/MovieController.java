package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
        Movie movie = movieService.getMovieByName(name);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovieNames() {
        List<String> movieNames = movieService.getAllMovieNames();
        return new ResponseEntity<>(movieNames, HttpStatus.OK);
    }

    @DeleteMapping("/delete-movie")
    public ResponseEntity<String> deleteMovie(@RequestBody Movie movie) {
        movieService.deleteMovie(movie);
        return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectorsMovies(@RequestBody Director director) {
        movieService.deleteAllDirectorsMovies(director);
        return new ResponseEntity<>("All movies by the director deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);
    }

}
