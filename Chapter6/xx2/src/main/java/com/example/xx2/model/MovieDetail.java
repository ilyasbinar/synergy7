package com.example.xx2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_detail")
public class MovieDetail extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String description;

    @OneToOne(targetEntity = Movie.class)
    @JoinColumn(name = "id_movie")
    private Movie movie;
}
