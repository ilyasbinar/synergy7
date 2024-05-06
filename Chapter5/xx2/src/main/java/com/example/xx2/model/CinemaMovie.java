package com.example.xx2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cinema_movie")
public class CinemaMovie extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "id_movie")
    private Movie movie;

    @ManyToOne(targetEntity = Cinema.class)
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean deleted; //true atau false
    private LocalDate deletedAt; //null atau ada nilai
}
