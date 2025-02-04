package com.movie.booking.movie_ticket_booking_system.service;

import com.movie.booking.movie_ticket_booking_system.entity.Movie;
import com.movie.booking.movie_ticket_booking_system.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

        public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
      public Movie getMovieBYTitle(String title){
        return movieRepository.findByTitle(title);
      }
      public void bookSeats(Long movieId, int numSeats){
        Movie movie = movieRepository.findById(movieId) .orElseThrow(() -> new IllegalArgumentException("Movie Not Found"));
        movie.bookSeats(numSeats);
        movieRepository.save(movie);
      }
}
