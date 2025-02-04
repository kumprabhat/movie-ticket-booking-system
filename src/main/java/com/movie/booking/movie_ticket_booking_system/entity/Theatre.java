package com.movie.booking.movie_ticket_booking_system.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "theatre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "theatreId")


public class Theatre {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "theatreId")
    private Long theatreId;
   @Column(name = "name", nullable = false)
    private String name;
   @Column(name = "location")
    private String location;
   @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 

   @JsonIgnore
    private Set<ShowTiming> showTimings = new HashSet<>();

}
