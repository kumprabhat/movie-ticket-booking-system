package com.movie.booking.movie_ticket_booking_system.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String message) {
        super(message);
    }
}
