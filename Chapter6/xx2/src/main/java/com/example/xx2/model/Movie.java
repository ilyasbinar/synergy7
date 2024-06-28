package com.example.xx2.model;

import com.example.xx2.payload.MovieListReportDto;
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
@Table(name = "movie")
@SQLDelete(sql = "update cinema set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Movie extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String name;

    //1: Semua Umur
    //2: BO
    //3: Dewasa
    private int type;

    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<CinemaMovie> cinemaMovies;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private MovieDetail movieDetail;

    public String getTypeLabel(){
        if(type==1) return "Semua Umur";
        else if(type==2) return "Bimbingan Orang Tua";
        else if(type==3) return "Dewasa";
        else return "N/A";
    }

    public MovieListReportDto toDto(){
        MovieListReportDto dto = new MovieListReportDto();
        dto.setId(id.toString());
        dto.setName(name);
        dto.setType(getTypeLabel());
        return dto;
    }

}
