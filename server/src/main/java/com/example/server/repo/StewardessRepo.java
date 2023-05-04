package com.example.server.repo;

import com.example.server.models.persons.Stewardess;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StewardessRepo extends CrudRepository<Stewardess,Long> {
    List<Stewardess> findAll();
}
