package com.example.unitTestingMockDemo.repository;

import com.example.unitTestingMockDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select \n" +
            "case \n" +
            "\twhen count(id)>0 then true\n" +
            "\telse false\n" +
            "end\n" +
            "from person p where id=?1",
            nativeQuery = true)
    boolean isPersonExistById(Long id);
}
