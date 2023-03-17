
package com.example.movie.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MovieController{
    @Autowired
    public MovieJpaService mjs;
    @GetMapping("/movies")
    public ArrayList<Movie> getMovie(){
        return mjs.getMovies();
    }
    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable ("movieId") int movieId){
        return mjs.getMovieById(movieId);
    }
    @PostMapping("/movies")
    public Movie addMovepost(@RequestBody Movie movie ){
        return mjs.addMovie(movie);
    }
    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable ("movieId") int movieId , @RequestBody Movie movie){
        return mjs.updateMovie(movieId , movie);
    }
    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable ("movieId") int movieId){
        mjs.deleteMovie(movieId);
    }

}