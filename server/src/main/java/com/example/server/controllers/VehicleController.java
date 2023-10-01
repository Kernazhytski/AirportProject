package com.example.server.controllers;

import com.example.server.models.vehicles.Bus;
import com.example.server.models.vehicles.FettlingMachine;
import com.example.server.models.vehicles.Plane;
import com.example.server.services.VehicleService;
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

    @PostMapping("/addBus")
    public ResponseEntity<?> add(@RequestBody Bus bus) {
        vehicleService.addBus(bus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addPlane")
    public ResponseEntity<?> add(@RequestBody Plane plane) {
        vehicleService.addPlane(plane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addFettlingMachine")
    public ResponseEntity<?> add(@RequestBody FettlingMachine fettlingMachine) {
        vehicleService.addFettlingMachine(fettlingMachine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "type",defaultValue = "all") String type) {
        System.out.println(vehicleService.getList(type));
        return new ResponseEntity<>(vehicleService.getList(type),HttpStatus.OK);
    }
}
