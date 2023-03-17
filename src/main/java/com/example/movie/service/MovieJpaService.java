package com.example.movie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.MovieJpaRepository;


@Service
public class MovieJpaService implements MovieRepository{
    @Autowired
    private MovieJpaRepository mjp;
    @Override
    public ArrayList<Movie> getMovies(){
        List<Movie> m = mjp.findAll();
        ArrayList<Movie> ms = new ArrayList<>(m);
        return ms;
    }
    @Override
    public Movie getMovieById(int movieId){
        try{
            Movie mm = mjp.findById(movieId).get();
            return mm;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public Movie addMovie(Movie movie){
        mjp.save(movie);
        return movie;
    }
    public Movie updateMovie(int movieId , Movie movie){
        try{
            Movie m = mjp.findById(movieId).get();
            if(movie.getMovieName() != null){
                m.setMovieName(movie.getMovieName());
            }
            if(movie.getLeadActor() != null){
                m.setLeadActor(movie.getLeadActor());
            }
            mjp.save(m);
            return m;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public void deleteMovie(int movieId){
        try{
            mjp.deleteById(movieId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}