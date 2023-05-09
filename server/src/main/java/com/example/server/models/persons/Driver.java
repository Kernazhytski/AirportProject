package com.example.server.models.persons;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Driver extends Person {
    @NonNull
    protected String driverLycense;
}
