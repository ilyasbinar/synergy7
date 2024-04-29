package com.example.xx2.repository;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    List<Movie> findByType(int type);

    @Query(value = "select m.* from movie m\n" +
            "inner join cinema_movie cm on m.id =cm.id_movie \n" +
            "where cm.id_cinema ='4aef6ad1-db67-4078-83ca-5898c3e1c43b'", nativeQuery = true)
    List<Movie> findKelapaGadingMovie();

}
