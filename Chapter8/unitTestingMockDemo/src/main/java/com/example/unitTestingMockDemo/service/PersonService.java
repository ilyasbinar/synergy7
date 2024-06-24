package com.example.unitTestingMockDemo.service;

import com.example.unitTestingMockDemo.entity.Person;
import com.example.unitTestingMockDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired private PersonRepository personRepository;

    public boolean isPersonExistById(Long id) {
        return personRepository.isPersonExistById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }
}
