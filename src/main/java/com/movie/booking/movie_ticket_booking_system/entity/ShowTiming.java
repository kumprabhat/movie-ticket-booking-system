package com.movie.booking.movie_ticket_booking_system.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
@NoArgsConstructor
@Entity
@Table(name = "showTiming")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ShowTiming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theatreId", nullable = false)
    private Theatre theatre;
    @Column(nullable = false)
    private LocalDateTime timing;


}
