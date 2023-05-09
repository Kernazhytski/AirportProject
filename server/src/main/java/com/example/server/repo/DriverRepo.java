package com.example.server.repo;


import com.example.server.models.persons.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepo extends CrudRepository<Driver,Long> {
    List<Driver> findAll();
}
