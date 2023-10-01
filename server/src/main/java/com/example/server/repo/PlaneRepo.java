package com.example.server.repo;

import com.example.server.models.vehicles.Plane;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaneRepo extends CrudRepository<Plane, Integer> {
    List<Plane> findAll();
}
