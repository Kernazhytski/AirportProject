package com.example.server.controllers;

import com.example.server.DTO.vehicles.BusRequestDTO;
import com.example.server.DTO.vehicles.FettlingMachineRequestDTO;
import com.example.server.DTO.vehicles.PlaneRequestDTO;
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
    public ResponseEntity<?> add(@RequestBody BusRequestDTO requestDTO) {
        vehicleService.addBus(requestDTO);
        LOGGER.info("Added new bus: " + requestDTO.toString());
        return new ResponseEntity<>("New Bus is added", HttpStatus.CREATED);
    }

    @PostMapping("/addPlane")
    public ResponseEntity<?> add(@RequestBody PlaneRequestDTO requestDTO) {
        vehicleService.addPlane(requestDTO);
        LOGGER.info("Added new plane: " + requestDTO.toString());
        return new ResponseEntity<>("New Plane is added", HttpStatus.CREATED);
    }

    @PostMapping("/addFettlingMachine")
    public ResponseEntity<?> add(@RequestBody FettlingMachineRequestDTO requestDTO) {
        vehicleService.addFettlingMachine(requestDTO);
        LOGGER.info("Added new fettlingMachine: " + requestDTO.toString());
        return new ResponseEntity<>("New FettlingMahine is added", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "type",defaultValue = "all") String type) {
        LOGGER.info("Getting a list of vehicles.");
        return new ResponseEntity<>(vehicleService.getList(type), HttpStatus.OK);
    }
}
