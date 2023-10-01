package com.example.server.repo;

import com.example.server.models.vehicles.FettlingMachine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FettlingMachineRepo extends CrudRepository<FettlingMachine, Integer> {
    List<FettlingMachine> findAll();
}
