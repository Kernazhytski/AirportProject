package com.example.server.models.vehicles;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class FettlingMachine extends Vehicle {

    @NotNull
    private int fuelVolume;

    public FettlingMachine(Integer id, String type, String model, String number, int crews, int fuelVolume) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.number = number;
        this.crews = 0;
        this.maxCrewSize = crews;
        this.fuelVolume = fuelVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FettlingMachine plane = (FettlingMachine) o;
        return id == plane.id &&
                type.equals(plane.type) &&
                model.equals(plane.model) &&
                number.equals(plane.number) &&
                crews == plane.crews &&
                fuelVolume == plane.fuelVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, model, number, crews, fuelVolume);
    }
}
