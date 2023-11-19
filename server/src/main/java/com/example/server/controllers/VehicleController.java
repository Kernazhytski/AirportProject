package com.example.server.controllers;

import com.example.server.DTO.vehicles.BusRequestDTO;
import com.example.server.DTO.vehicles.FettlingMachineRequestDTO;
import com.example.server.DTO.vehicles.PlaneRequestDTO;
import com.example.server.models.persons.Person;
import com.example.server.models.vehicles.Vehicle;
import com.example.server.services.PersonService;
import com.example.server.services.VehicleService;
import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    private PersonService personService;

    private static final Logger LOGGER = Logger.getLogger(VehicleController.class);

    @PostMapping("/addBus")
    public ResponseEntity<?> add(@RequestBody BusRequestDTO requestDTO) {
        try {
            vehicleService.addBus(requestDTO);
        } catch(IllegalStateException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Added new bus: " + requestDTO.toString());
        return new ResponseEntity<>("New Bus is added", HttpStatus.CREATED);
    }

    @PostMapping("/addPlane")
    public ResponseEntity<?> add(@RequestBody PlaneRequestDTO requestDTO) {
        try {
            vehicleService.addPlane(requestDTO);
        } catch(IllegalStateException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Added new plane: " + requestDTO.toString());
        return new ResponseEntity<>("New Plane is added", HttpStatus.CREATED);
    }

    @PostMapping("/addFettlingMachine")
    public ResponseEntity<?> add(@RequestBody FettlingMachineRequestDTO requestDTO) {
        try {
            vehicleService.addFettlingMachine(requestDTO);
        } catch(IllegalStateException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("Added new fettlingMachine: " + requestDTO.toString());
        return new ResponseEntity<>("New FettlingMahine is added", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "type",defaultValue = "all") String type) {
        LOGGER.info("Getting a list of vehicles.");
        return new ResponseEntity<>(vehicleService.getList(type), HttpStatus.OK);
    }

    @PostMapping("/assignPerson")
    public ResponseEntity<?>  assignPersonToVehicle(@RequestParam Long personId, @RequestParam String personType,
                                                    @RequestParam Integer vehicleId, @RequestParam String vehicleType) {
        Person person;
        Vehicle vehicle;
        try {
            person = personService.getPersonById(personType, personId);
            vehicle = vehicleService.getVehicleById(vehicleType, vehicleId);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        try {
            personService.assignWorkerToVehicle(person, vehicle);
            return new ResponseEntity<>("Person assigned to vehicle successfully", HttpStatus.OK);
        }  catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
