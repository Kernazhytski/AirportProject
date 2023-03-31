package com.example.server.controllers;

import com.example.server.models.Vehicle;
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

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "type",defaultValue = "all") String type) {
        return new ResponseEntity<>(vehicleService.getList(type),HttpStatus.OK);
    }
}
