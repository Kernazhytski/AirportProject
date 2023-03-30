package com.example.server.services;

import com.example.server.models.Vehicle;
import com.example.server.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    public void addVehicle(Vehicle vehicle){
        vehicleRepo.save(vehicle);
    }
}
