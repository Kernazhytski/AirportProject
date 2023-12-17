package com.example.server.controllers;

import com.example.server.services.PersonVehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class PersonsVehicleController {

    @Autowired
    private PersonVehicleService personVehicleService;

    private static final Logger LOGGER = Logger.getLogger(PersonsVehicleController.class);

    @GetMapping("/PersonsVehicle")
    public ResponseEntity<?> getPersonVehicleList(@RequestParam(value = "type", defaultValue = "bus") String type) {
        try {
            List<List<?>> response = personVehicleService.getPersonsVehicle(type);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            LOGGER.error("invalid argument for getting list of person's vehicles");
            return new ResponseEntity<>("invalid argument for getting list of person's vehicles", HttpStatus.BAD_REQUEST);
        }
    }

}
