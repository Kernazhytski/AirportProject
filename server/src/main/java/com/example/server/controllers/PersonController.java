package com.example.server.controllers;

import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
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
    @Autowired
    private static final Logger LOGGER = Logger.getLogger(PersonController.class);

    @PostMapping("/addPilot")
    public ResponseEntity<?> addPilot(@RequestBody Pilot pilot) {
        personService.addPilot(pilot);
        LOGGER.info("Added new pilot: " + pilot.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addDriver")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver) {
        personService.addDriver(driver);
        LOGGER.info("Added new driver: " + driver.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addStewardess")
    public ResponseEntity<?> addStewardess(@RequestBody Stewardess stewardess) {
        personService.addStewardess(stewardess);
        LOGGER.info("Added new stewardess: " + stewardess.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getPersons(@RequestParam(value = "job", defaultValue = "all") String job,
                                        @RequestParam(value = "fields", defaultValue = "all") String fields) {
        //System.out.println(personService.getList(job, fields));
        LOGGER.info("Getting a list of persons.");
        return new ResponseEntity<>(personService.getList(job), HttpStatus.OK);
    }
}
