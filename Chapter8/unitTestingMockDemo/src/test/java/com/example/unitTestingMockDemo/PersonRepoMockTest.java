package com.example.unitTestingMockDemo;

import com.example.unitTestingMockDemo.entity.Person;
import com.example.unitTestingMockDemo.repository.PersonRepository;
import com.example.unitTestingMockDemo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonRepoMockTest {
    @Mock
    PersonRepository personRepository;

    @Mock
    PersonService personService;

    @Test
    void isPersonExistById(){
        Person person = Person.builder().id(124L).name("Syihab").city("Jakarta").build();
        personService.save(person);

        boolean actualResult = personService.isPersonExistById(123L);
        assertThat(actualResult).isTrue();
    }
}
