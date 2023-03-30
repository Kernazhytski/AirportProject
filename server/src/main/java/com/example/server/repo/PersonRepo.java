package com.example.server.repo;

import com.example.server.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Integer> {
    List<Person> findAll();
}
