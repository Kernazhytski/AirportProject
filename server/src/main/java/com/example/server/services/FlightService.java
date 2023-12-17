package com.example.server.services;

import com.example.server.DTO.flights.FlightRequestDTO;
import com.example.server.DTO.flights.FlightResponseDTO;
import com.example.server.models.Flight;
import com.example.server.repo.FlightRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.apache.log4j.Logger;
import org.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(FlightService.class);

    public void addFlight(FlightRequestDTO flightRequestDTO) throws Exception {
        Flight flight = buildFlightRequest(flightRequestDTO);

        List<Flight> existingFlights = flightRepo.findByPlaneId(flight.getPlaneId());



        boolean hasConflict = existingFlights.stream()
                .anyMatch(existingFlight -> DateCompare.compareDates(
                        new LocalDateTime[] {existingFlight.getDepartureTime(), existingFlight.getArrivalTime()},
                        new LocalDateTime[] {flight.getDepartureTime(), flight.getArrivalTime()}));

        if(hasConflict) {
            throw new Exception("There is a time conflict for this plane.");
        } else {
            flightRepo.save(flight);
        }
    }

    public FlightResponseDTO getFlightById(Integer id) {
        return buildFlightResponse(flightRepo.findById(id).orElse(null));
    }

    public List<FlightResponseDTO> getFlightsList() {
        return flightRepo.findAll()
                .stream()
                .map(this::buildFlightResponse)
                .collect(Collectors.toList());
    }

    @Scheduled(cron = "0 0 * * * *") // каждый час
    //@Scheduled(cron = "0 * * * * *") // каждую минуту
    public void updateFlightStatusByStoredProcedure(){
        LOGGER.info("Flight status updates in progress");
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("UpdateFlightStatus");
        query.execute();
        LOGGER.info("Flight status updates finished");
    }

    public FlightResponseDTO buildFlightResponse(Flight flight) {
        return new FlightResponseDTO()
                .setFlightNumber(flight.getFlightNumber())
                .setDepartureTime(flight.getDepartureTime())
                .setArrivalTime(flight.getArrivalTime())
                .setFromTown(flight.getFromTown())
                .setToTown(flight.getToTown())
                .setFlightStatus(flight.getFlightStatus());
    }

    private Flight buildFlightRequest(FlightRequestDTO requestDTO) {
        return new Flight()
                .setFlightNumber(requestDTO.getFlightNumber())
                .setDepartureTime(requestDTO.getDepartureTime())
                .setArrivalTime(requestDTO.getArrivalTime())
                .setFromTown(requestDTO.getFromTown())
                .setToTown(requestDTO.getToTown())
                .setFlightStatus(requestDTO.getFlightStatus())
                .setPlaneId(requestDTO.getPlaneId());
    }
}
