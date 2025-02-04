package com.movie.booking.movie_ticket_booking_system.service;

import com.movie.booking.movie_ticket_booking_system.entity.Movie;
import com.movie.booking.movie_ticket_booking_system.entity.ShowTiming;
import com.movie.booking.movie_ticket_booking_system.exception.MovieNotFoundException;
import com.movie.booking.movie_ticket_booking_system.repository.MovieRepository;
import com.movie.booking.movie_ticket_booking_system.repository.ShowTimingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowTimingService {

    private final ShowTimingRepository showTimingRepository;
    private final MovieService movieService;

    public ShowTimingService(ShowTimingRepository showTimingRepository, MovieService movieService) {
        this.showTimingRepository = showTimingRepository;
        this.movieService = movieService;
    }
    public List<ShowTiming> getShowTimings(LocalDateTime date, String movieTitle){
        Movie movie = movieService.getMovieBYTitle(movieTitle);
        if(null == movie){
            throw new MovieNotFoundException("Movie Not found with title"+movieTitle);
        }
        List<ShowTiming> showTimings = showTimingRepository.findByTimingAndMovie(date,movie);
        return showTimings;

    }
}
