package com.example.server.repo;

import com.example.server.models.vehicles.Bus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusRepo extends CrudRepository<Bus, Integer> {
    List<Bus> findAll();
}
