package com.movie.booking.movie_ticket_booking_system.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name = "movies")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "movieId")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movieId")
    private Long movieId;
    @Column(name="title")
    private String title;
    @Column(name="genre")
    private String genre;
    @Column(name="director")
    private String director;
    @Column(name="release_date")
    private String releaseDate;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ShowTiming> showTimings = new HashSet();

    public void bookSeats(int numSeats) {
        if (numSeats <= 0) {
            throw new IllegalArgumentException("invalid number of seats");
        }
    }
}

