package com.movie.booking.movie_ticket_booking_system.service;

import com.movie.booking.movie_ticket_booking_system.entity.Movie;
import com.movie.booking.movie_ticket_booking_system.entity.ShowTiming;
import com.movie.booking.movie_ticket_booking_system.entity.Theatre;
import com.movie.booking.movie_ticket_booking_system.repository.MovieRepository;
import com.movie.booking.movie_ticket_booking_system.repository.ShowTimingRepository;
import com.movie.booking.movie_ticket_booking_system.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TheatreService {
    private final TheatreRepository theatreRepository;
    private final ShowTimingRepository showTimingRepository;
    private final MovieRepository movieRepository;

    public TheatreService(TheatreRepository theatreRepository, ShowTimingRepository showTimingRepository, MovieRepository movieRepository) {
        this.theatreRepository = theatreRepository;
        this.showTimingRepository = showTimingRepository;
        this.movieRepository = movieRepository;
    }

    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    public List<ShowTiming> getShowTimings(String movieTitle, LocalDateTime dateTime){
        Movie movie = movieRepository.findByTitle(movieTitle);
        List<Theatre> theatres = theatreRepository.findAll();
        return showTimingRepository.findByTimingAndMovie(dateTime,movie);

    }
}
