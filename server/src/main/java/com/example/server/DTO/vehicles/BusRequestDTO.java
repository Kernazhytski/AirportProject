package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BusRequestDTO extends VehicleRequestDTO{
    private int passengers;
}
