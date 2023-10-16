package com.example.server.controllers;

import com.example.server.models.vehicles.Bus;
import com.example.server.models.vehicles.FettlingMachine;
import com.example.server.models.vehicles.Plane;
import com.example.server.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    private static final Logger LOGGER = Logger.getLogger(VehicleController.class);

    @PostMapping("/addBus")
    public ResponseEntity<?> add(@RequestBody Bus bus) {
        vehicleService.addBus(bus);
        LOGGER.info("Added new bus: " + bus.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addPlane")
    public ResponseEntity<?> add(@RequestBody Plane plane) {
        vehicleService.addPlane(plane);
        LOGGER.info("Assed new plane: " + plane.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addFettlingMachine")
    public ResponseEntity<?> add(@RequestBody FettlingMachine fettlingMachine) {
        vehicleService.addFettlingMachine(fettlingMachine);
        LOGGER.info("Added new fettlingMachine: " + fettlingMachine.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "type",defaultValue = "all") String type) {
        //System.out.println(vehicleService.getList(type));
        LOGGER.info("Getting a list of vehicles.");
        return new ResponseEntity<>(vehicleService.getList(type),HttpStatus.OK);
    }
}
