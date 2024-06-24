package com.example.unitTestingMockDemo;

import com.example.unitTestingMockDemo.entity.Person;
import com.example.unitTestingMockDemo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonRepoTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    void isPersonExistById(){
        Person person = Person.builder().id(124L).name("Syihab").city("Jakarta").build();
        personRepository.save(person);

        boolean actualResult = personRepository.isPersonExistById(123L);

        Person person1 = personRepository.findById(123L).get();

        assertThat(person1).isEqualTo(person);
    }
}
