package com.example.server.controllers;

import com.example.server.DTO.persons.DriverRequestDTO;
import com.example.server.DTO.persons.PilotRequestDTO;
import com.example.server.DTO.persons.StewardessRequestDTO;
import com.example.server.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:5000")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Logger LOGGER = Logger.getLogger(PersonController.class);

    @PostMapping("/addPilot")
    public ResponseEntity<?> addPilot(@RequestBody PilotRequestDTO pilotRequestDTO) {
        personService.addPilot(pilotRequestDTO);
        LOGGER.info("Added new pilot: " + pilotRequestDTO.toString());
        return new ResponseEntity<>("New Pilot is added", HttpStatus.CREATED);
    }

    @PostMapping("/addDriver")
    public ResponseEntity<?> addDriver(@RequestBody DriverRequestDTO driverRequestDTO) {
        personService.addDriver(driverRequestDTO);
        LOGGER.info("Added new driver: " + driverRequestDTO.toString());
        return new ResponseEntity<>("New Driver is added", HttpStatus.CREATED);
    }

    @PostMapping("/addStewardess")
    public ResponseEntity<?> addStewardess(@RequestBody StewardessRequestDTO stewardessRequestDTO) {
        personService.addStewardess(stewardessRequestDTO);
        LOGGER.info("Added new stewardess: " + stewardessRequestDTO.toString());
        return new ResponseEntity<>("New Stewardess is added",HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getPersons(@RequestParam(value = "job", defaultValue = "all") String job) {
        LOGGER.info("Getting a list of persons.");
        return new ResponseEntity<>(personService.getList(job), HttpStatus.OK);
    }
}
