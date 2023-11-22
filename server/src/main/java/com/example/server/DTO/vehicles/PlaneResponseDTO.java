package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlaneResponseDTO extends VehicleResponseDTO {
    private int passengers;
}
