package com.example.server.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table-generator")
    @TableGenerator(name = "table-generator", allocationSize = 1)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String flightNumber;
    @NonNull
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @NonNull
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    @NonNull
    @Column(nullable = false)
    private String fromTown;
    @NonNull
    @Column(nullable = false)
    private String toTown;
    @NonNull
    @Column(nullable = false)
    private String flightStatus;

    @NotNull
    @Column(nullable = false)
    private int planeId;


    public Flight(Integer id, String flightNumber, LocalDateTime departureTime, LocalDateTime arrivalTime, String fromTown, String toTown) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fromTown = fromTown;
        this.toTown = toTown;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                ((flightNumber.equals(flight.flightNumber)) &&
                        (departureTime.equals(flight.departureTime)) &&
                        (arrivalTime.equals(flight.arrivalTime)) &&
                        (fromTown.equals(flight.fromTown)) &&
                        (toTown.equals(flight.toTown)));
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, departureTime, arrivalTime, fromTown, toTown);
    }
}
