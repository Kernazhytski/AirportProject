package com.example.server.repo;

import com.example.server.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepo extends CrudRepository<Vehicle, Integer> {
    List<Vehicle> findAll();
}
