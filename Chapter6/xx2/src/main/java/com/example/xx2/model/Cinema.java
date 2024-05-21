package com.example.xx2.model;

import com.example.xx2.payload.CinemaDto;
import com.example.xx2.payload.CinemaUpdateAddressRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cinema")
@SQLDelete(sql = "update cinema set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Cinema extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address;

    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<CinemaMovie> cinemaMovies;

}
