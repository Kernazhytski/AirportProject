package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FettlingMachineResponseDTO extends VehicleResponseDTO {
    private int fuelVolume;
}
