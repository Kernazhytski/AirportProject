package com.example.server.controllers;

import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {
    @Autowired
    private Environment env;
    @Autowired
    private PersonService personService;

    @PostMapping("/addPilot")
    public ResponseEntity<?> addPilot(@RequestBody Pilot pilot) {
        personService.addPilot(pilot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addDriver")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver) {
        personService.addDriver(driver);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addStewardess")
    public ResponseEntity<?> addStewardess(@RequestBody Stewardess stewardess) {
        personService.addStewardess(stewardess);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "job", defaultValue = "all") String job,
                                        @RequestParam(value = "fields", defaultValue = "all") String fields) {
        System.out.println(personService.getList(job, fields));
        return new ResponseEntity<>(personService.getList(job, fields), HttpStatus.OK);
    }
}
