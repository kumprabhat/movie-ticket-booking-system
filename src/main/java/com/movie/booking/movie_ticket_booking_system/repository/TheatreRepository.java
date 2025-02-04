package com.movie.booking.movie_ticket_booking_system.repository;

import com.movie.booking.movie_ticket_booking_system.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {

}
