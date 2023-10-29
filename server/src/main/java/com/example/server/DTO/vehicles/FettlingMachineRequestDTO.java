package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FettlingMachineRequestDTO extends VehicleRequestDTO {
    /*private String type;
    private String model;
    private String number;
    private int crews;*/
    private int fuelVolume;
}
