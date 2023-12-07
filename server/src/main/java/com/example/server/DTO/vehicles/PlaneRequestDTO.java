package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlaneRequestDTO extends VehicleRequestDTO {
    private int passengers;
}
