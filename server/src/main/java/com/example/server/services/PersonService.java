package com.example.server.services;


import com.example.server.DTO.persons.*;
import com.example.server.DTO.vehicles.VehicleRequestDTO;
import com.example.server.DTO.vehicles.VehicleResponseDTO;
import com.example.server.models.Gender;
import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.models.vehicles.Bus;
import com.example.server.models.vehicles.FettlingMachine;
import com.example.server.models.vehicles.Plane;
import com.example.server.models.vehicles.Vehicle;
import com.example.server.repo.DriverRepo;
import com.example.server.repo.PilotRepo;
import com.example.server.repo.StewardessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    List<List<?>> response;

    @Autowired
    private PilotRepo pilotRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private StewardessRepo stewardessRepo;

    public void addPilot(PilotRequestDTO pilotRequestDTO) {
        Pilot pilot = buildPilotRequest(pilotRequestDTO);
        pilotRepo.save(pilot);
    }

    public void addDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = buildDriverRequest(driverRequestDTO);
        driverRepo.save(driver);
    }

    public void addStewardess(StewardessRequestDTO stewardessRequestDTO) {
        Stewardess stewardess = buildStewardessRequest(stewardessRequestDTO);
        stewardessRepo.save(stewardess);
    }

    public List<List<?>> getList(String job) {
        response = new ArrayList<>();
        if (job.equals("all")) {
            response.add(driverRepo.findAll()
                    .stream()
                    .map(this::buildDriverResponse)
                    .collect(Collectors.toList()));

            response.add(pilotRepo.findAll()
                    .stream()
                    .map(this::buildPilotResponse)
                    .collect(Collectors.toList()));

            response.add(stewardessRepo.findAll()
                    .stream()
                    .map(this::buildStewardessResponse)
                    .collect(Collectors.toList()));
        } else {
            switch(job){
                case "pilot" -> response.add(pilotRepo.findAll()
                        .stream()
                        .map(this::buildPilotResponse)
                        .collect(Collectors.toList()));

                case "driver" -> response.add(driverRepo.findAll()
                        .stream()
                        .map(this::buildDriverResponse)
                        .collect(Collectors.toList()));

                case "stewardess" -> response.add(stewardessRepo.findAll()
                        .stream()
                        .map(this::buildStewardessResponse)
                        .collect(Collectors.toList()));

                default -> throw new IllegalStateException("Unexpected job: " + job);
            }
        }
        return response;
    }

    private DriverResponseDTO buildDriverResponse(Driver driver) {
        return new DriverResponseDTO()
                .setFirstName(driver.getFirstName())
                .setSecondName(driver.getSecondName())
                .setAge(driver.getAge())
                .setGender(new Gender()
                        .setGender(driver.getGender().getGender()))
                .setDriverLycense(driver.getDriverLycense())
                .setVehicleResponseDTO(driver.getVehicle() == null ? null : new VehicleResponseDTO()
                        .setId(driver.getVehicle().getId())
                        .setType(driver.getVehicle().getType())
                        .setModel(driver.getVehicle().getModel())
                        .setNumber(driver.getVehicle().getNumber()));
    }

    private Driver buildDriverRequest(DriverRequestDTO requestDTO) {
        VehicleRequestDTO vehicleRequestDTO = requestDTO.getBusRequestDTO() == null ? requestDTO.getFettlingMachineRequestDTO(): requestDTO.getBusRequestDTO();
        Vehicle vehicle = null;

        switch (vehicleRequestDTO.getType()) {
            case "bus" -> vehicle = new Bus()
                    .setPassengers(requestDTO.getBusRequestDTO().getPassengers())
                    .setType(vehicleRequestDTO.getType())
                    .setModel(vehicleRequestDTO.getModel())
                    .setNumber(vehicleRequestDTO.getNumber())
                    .setCrews(vehicleRequestDTO.getCrews());
            case "fettlingMachine" -> vehicle = new FettlingMachine()
                    .setFuelVolume(requestDTO.getFettlingMachineRequestDTO().getFuelVolume())
                    .setType(vehicleRequestDTO.getType())
                    .setModel(vehicleRequestDTO.getModel())
                    .setNumber(vehicleRequestDTO.getNumber())
                    .setCrews(vehicleRequestDTO.getCrews());
        }

        return (Driver) new Driver()
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()))
                .setVehicle(vehicle);

    }

    private PilotResponseDTO buildPilotResponse(Pilot pilot) {
        return new PilotResponseDTO()
                .setFirstName(pilot.getFirstName())
                .setSecondName(pilot.getSecondName())
                .setAge(pilot.getAge())
                .setGender(new Gender()
                        .setGender(pilot.getGender().getGender()))
                .setPilotLycense(pilot.getPilotLycense())
                .setVehicleResponseDTO(pilot.getVehicle() == null ? null : new VehicleResponseDTO()
                        .setId(pilot.getVehicle().getId())
                        .setType(pilot.getVehicle().getType())
                        .setModel(pilot.getVehicle().getModel())
                        .setNumber(pilot.getVehicle().getNumber()));
    }

    private Pilot buildPilotRequest(PilotRequestDTO requestDTO) {
        return (Pilot) new Pilot()
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()))
                .setVehicle(new Plane()
                        .setPassengers(requestDTO.getPlaneRequestDTO().getPassengers())
                        .setType(requestDTO.getPlaneRequestDTO().getType())
                        .setModel(requestDTO.getPlaneRequestDTO().getModel())
                        .setNumber(requestDTO.getPlaneRequestDTO().getNumber())
                        .setCrews(requestDTO.getPlaneRequestDTO().getCrews()));
    }

    private StewardessResponseDTO buildStewardessResponse(Stewardess stewardess) {
        return new StewardessResponseDTO()
                .setLanguages(stewardess.getLanguages())
                .setFirstName(stewardess.getFirstName())
                .setSecondName(stewardess.getSecondName())
                .setAge(stewardess.getAge())
                .setGender(new Gender()
                        .setGender(stewardess.getGender().getGender()));
    }

    private Stewardess buildStewardessRequest(StewardessRequestDTO requestDTO) {
        return (Stewardess) new Stewardess()
                .setLanguages(requestDTO.getLanguages())
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()));
    }
}
