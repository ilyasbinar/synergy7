package com.example.xx2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String name;

    private int type;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<CinemaMovie> cinemaMovies;
}
