package com.example.server.repo;

import com.example.server.models.persons.Pilot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PilotRepo extends CrudRepository<Pilot, Long> {
    List<Pilot> findAll();
}
