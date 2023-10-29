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
public class Plane extends Vehicle {

    @NotNull
    private int passengers;

    public Plane(Integer id, String type, String model, String number, int crews, int passengers) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.number = number;
        this.crews = crews;
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return id == plane.id &&
                type.equals(plane.type) &&
                model.equals(plane.model) &&
                number.equals(plane.number) &&
                crews == plane.crews &&
                passengers == plane.passengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, model, number, crews, passengers);
    }
}
