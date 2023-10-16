package com.example.server.services;

import com.example.server.models.vehicles.Bus;
import com.example.server.models.vehicles.FettlingMachine;
import com.example.server.models.vehicles.Plane;
import com.example.server.repo.BusRepo;
import com.example.server.repo.FettlingMachineRepo;
import com.example.server.repo.PlaneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleService {
    List<List<?>> response;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private PlaneRepo planeRepo;

    @Autowired
    private FettlingMachineRepo fettlingMachineRepo;

    public void addBus(Bus bus) {busRepo.save(bus);}

    public void addPlane(Plane plane) {planeRepo.save(plane);}

    public void addFettlingMachine(FettlingMachine fettlingMachine) {fettlingMachineRepo.save(fettlingMachine);}

    public List<List<?>> getList(String type) {
        response = new ArrayList<>();
        if(type.equals("all")) {
            response.add(busRepo.findAll());
            response.add(planeRepo.findAll());
            response.add(fettlingMachineRepo.findAll());
        } else {
            switch(type) {
                case "bus" -> response.add(busRepo.findAll());
                case "plane" -> response.add(planeRepo.findAll());
                case "fettlingMachine" -> response.add(fettlingMachineRepo.findAll());
                default -> throw new IllegalStateException("Unexpected type of vehicle: " + type);
            }
        }

        return response;
    }
}
