package com.example.server.controllers;

import com.example.server.DTO.flights.FlightRequestDTO;
import com.example.server.DTO.flights.FlightResponseDTO;
import com.example.server.services.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FlightController {
    private final FlightService flightService;

    private static final Logger LOGGER = Logger.getLogger(FlightController.class);

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody FlightRequestDTO flightRequestDTO) {
        try {
            flightService.addFlight(flightRequestDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        LOGGER.info("Added new flight from - " + flightRequestDTO.getFromTown() + " to " + flightRequestDTO.getToTown());
        return new ResponseEntity<>("New flight is added", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFlight(@PathVariable Integer id) {
        FlightResponseDTO flightResponse = flightService.getFlightById(id);
        return flightResponse != null ? new ResponseEntity<>(flightResponse, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getFlights() {
        return new ResponseEntity<>(flightService.getFlightsList(), HttpStatus.OK);
    }
}
