package com.movie.booking.movie_ticket_booking_system.controller;

import com.movie.booking.movie_ticket_booking_system.entity.Movie;
import com.movie.booking.movie_ticket_booking_system.entity.ShowTiming;
import com.movie.booking.movie_ticket_booking_system.entity.Theatre;
import com.movie.booking.movie_ticket_booking_system.service.MovieService;
import com.movie.booking.movie_ticket_booking_system.service.ShowTimingService;
import com.movie.booking.movie_ticket_booking_system.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("movie/ticket-booking")
public class MovieBookingController {

    private final TheatreService theatreService;
    private final ShowTimingService showTimingService;
    private final MovieService movieService;

    public MovieBookingController(TheatreService theatreService, ShowTimingService showTimingService, MovieService movieService) {
        this.theatreService = theatreService;
        this.showTimingService = showTimingService;
        this.movieService = movieService;
    }
    @GetMapping("/theatres")
    public ResponseEntity<List<Theatre>> getAllTheatres(){
        List<Theatre> theatres = theatreService.getAllTheatres();
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }

    @GetMapping("/shows")
    public ResponseEntity<List<ShowTiming>> getShowsByDateAndMovie(
            @RequestParam String date,
            @RequestParam String movieTitle
    ) {
        LocalDateTime chosenDate = LocalDateTime.parse(date);
        List<ShowTiming> shows = showTimingService.getShowTimings(chosenDate, movieTitle);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @PostMapping("/{movieId}/book")
    public ResponseEntity<String> bookSeats(
            @PathVariable Long movieId,
            @RequestParam int numSeats) {

        try {
            movieService.bookSeats(movieId, numSeats);
            return ResponseEntity.ok("Seats booked successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
