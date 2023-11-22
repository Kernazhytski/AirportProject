package com.example.server.DTO.flights;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FlightResponseDTO {
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String fromTown;
    private String toTown;
    private String flightStatus;
}
