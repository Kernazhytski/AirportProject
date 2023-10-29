package com.example.server.services;

import com.example.server.DTO.vehicles.*;
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
import java.util.stream.Collectors;

@Component
public class VehicleService {
    List<List<?>> response;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private PlaneRepo planeRepo;

    @Autowired
    private FettlingMachineRepo fettlingMachineRepo;

    public void addBus(BusRequestDTO busRequestDTO) {
        Bus bus = buildBusRequest(busRequestDTO);
        busRepo.save(bus);
    }

    public void addPlane(PlaneRequestDTO planeRequestDTO) {
        Plane plane = buildPlaneRequest(planeRequestDTO);
        planeRepo.save(plane);
    }

    public void addFettlingMachine(FettlingMachineRequestDTO fettlingMachineRequestDTO) {
        FettlingMachine fettlingMachine = buildFettlingMachineRequest(fettlingMachineRequestDTO);
        fettlingMachineRepo.save(fettlingMachine);
    }

    public List<List<?>> getList(String type) {
        response = new ArrayList<>();
        if(type.equals("all")) {
            response.add(busRepo.findAll()
                    .stream()
                    .map(this::buildBusResponse)
                    .collect(Collectors.toList()));

            response.add(planeRepo.findAll()
                    .stream()
                    .map(this::buildPlaneResponse)
                    .collect(Collectors.toList()));

            response.add(fettlingMachineRepo.findAll()
                    .stream()
                    .map(this::buildFettlingMachineResponse)
                    .collect(Collectors.toList()));
        } else {
            switch(type) {
                case "bus" -> response.add(busRepo.findAll()
                        .stream()
                        .map(this::buildBusResponse)
                        .collect(Collectors.toList()));

                case "plane" -> response.add(planeRepo.findAll()
                        .stream()
                        .map(this::buildPlaneResponse)
                        .collect(Collectors.toList()));

                case "fettlingMachine" -> response.add(fettlingMachineRepo.findAll()
                        .stream()
                        .map(this::buildFettlingMachineResponse)
                        .collect(Collectors.toList()));

                default -> throw new IllegalStateException("Unexpected type of vehicle: " + type);
            }
        }

        return response;
    }

    private BusResponseDTO buildBusResponse(Bus bus) {
        return (BusResponseDTO) new BusResponseDTO()
                .setId(bus.getId())
                .setType(bus.getType())
                .setModel(bus.getModel())
                .setNumber(bus.getNumber());
    }

    private Bus buildBusRequest(BusRequestDTO requestDTO) {
        return (Bus) new Bus()
                .setPassengers(requestDTO.getPassengers())
                .setType(requestDTO.getType())
                .setModel(requestDTO.getModel())
                .setNumber(requestDTO.getNumber())
                .setCrews(requestDTO.getCrews());
    }

    private PlaneResponseDTO buildPlaneResponse(Plane plane) {
        return (PlaneResponseDTO) new PlaneResponseDTO()
                .setId(plane.getId())
                .setType(plane.getType())
                .setModel(plane.getModel())
                .setNumber(plane.getNumber());
    }

    private Plane buildPlaneRequest(PlaneRequestDTO requestDTO) {
        return (Plane) new Plane()
                .setPassengers(requestDTO.getPassengers())
                .setType(requestDTO.getType())
                .setModel(requestDTO.getModel())
                .setNumber(requestDTO.getNumber())
                .setCrews(requestDTO.getCrews());
    }

    private FettlingMachineResponseDTO buildFettlingMachineResponse(FettlingMachine fettlingMachine) {
        return (FettlingMachineResponseDTO) new FettlingMachineResponseDTO()
                .setId(fettlingMachine.getId())
                .setType(fettlingMachine.getType())
                .setModel(fettlingMachine.getModel())
                .setNumber(fettlingMachine.getNumber());
    }

    private FettlingMachine buildFettlingMachineRequest(FettlingMachineRequestDTO requestDTO) {
        return (FettlingMachine) new FettlingMachine()
                .setFuelVolume(requestDTO.getFuelVolume())
                .setType(requestDTO.getType())
                .setModel(requestDTO.getModel())
                .setNumber(requestDTO.getNumber())
                .setCrews(requestDTO.getCrews());
    }
}
