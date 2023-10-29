package com.example.server.DTO.vehicles;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VehicleResponseDTO {
    protected Integer id;
    protected String type;
    protected String model;
    protected String number;
}
