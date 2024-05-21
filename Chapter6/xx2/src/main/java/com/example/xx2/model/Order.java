package com.example.xx2.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SQLDelete(sql = "update orders set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Order extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(targetEntity = CinemaMovie.class)
    @JoinColumn(name = "id_cinema_movie")
    private CinemaMovie cinemaMovie;

    private int amount;

    private boolean success = Boolean.FALSE;

    private boolean deleted = Boolean.FALSE;

}
