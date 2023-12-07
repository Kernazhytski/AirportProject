package com.example.server.DTO.persons;

import com.example.server.DTO.vehicles.VehicleResponseDTO;
import com.example.server.models.Gender;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class DriverResponseDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private String age;
    private Gender gender;
    private String driverLycense;
    private VehicleResponseDTO vehicleResponseDTO;
}
