package com.example.server.DTO.persons;

import com.example.server.DTO.vehicles.BusRequestDTO;
import com.example.server.DTO.vehicles.FettlingMachineRequestDTO;
import com.example.server.models.Gender;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class DriverRequestDTO {
    private String firstName;
    private String secondName;
    private String age;
    private Gender gender;
    private String driverLycense;
    private BusRequestDTO busRequestDTO;
    private FettlingMachineRequestDTO fettlingMachineRequestDTO;
}
