package com.movie.booking.movie_ticket_booking_system.repository;

import com.movie.booking.movie_ticket_booking_system.entity.Movie;
import com.movie.booking.movie_ticket_booking_system.entity.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ShowTimingRepository extends JpaRepository<ShowTiming, Long> {
    List<ShowTiming> findByTimingAndMovie(LocalDateTime timing, Movie movie);
}
