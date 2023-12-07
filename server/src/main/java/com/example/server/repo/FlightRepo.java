package com.example.server.repo;

import com.example.server.models.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepo extends CrudRepository<Flight, Integer> {
    List<Flight> findAll();
    List<Flight> findByPlaneId(int planeId);
}
