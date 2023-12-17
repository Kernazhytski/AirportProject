package com.example.server.services;

import com.example.server.DTO.persons.DriverResponseDTO;
import com.example.server.DTO.persons.PilotResponseDTO;
import com.example.server.DTO.persons.StewardessResponseDTO;
import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.repo.DriverRepo;
import com.example.server.repo.PilotRepo;
import com.example.server.repo.StewardessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonVehicleService {
    @Autowired
    private PersonService personService;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private PilotRepo pilotRepo;

    @Autowired
    private StewardessRepo stewardessRepo;

    public List<List<?>> getPersonsVehicle(String type) {
        List<List<?>> response = new ArrayList<>();

        List<Driver> drivers = driverRepo.findAll();
        List<DriverResponseDTO> driverResponseDTO = drivers.stream()
                .filter(driver -> driver.getVehicle() != null && driver.getVehicle().getType().equals(type))
                .map(personService::buildDriverResponse)
                .collect(Collectors.toList());

        List<Pilot> pilots = pilotRepo.findAll();
        List<PilotResponseDTO> pilotResponseDTO = pilots.stream()
                .filter(pilot -> pilot.getVehicle() != null && pilot.getVehicle().getType().equals(type))
                .map(personService::buildPilotResponse)
                .collect(Collectors.toList());

        List<Stewardess> stewardesses = stewardessRepo.findAll();
        List<StewardessResponseDTO> stewardessResponseDTO = stewardesses.stream()
                .filter(stewardess -> stewardess.getVehicle() != null && stewardess.getVehicle().getType().equals(type))
                .map(personService::buildStewardessResponse)
                .collect(Collectors.toList());

        response.add(driverResponseDTO);
        response.add(pilotResponseDTO);
        response.add(stewardessResponseDTO);

        return response;
    }
}
