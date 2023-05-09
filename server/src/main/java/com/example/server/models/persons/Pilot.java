package com.example.server.models.persons;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Pilot extends Person {

    @NonNull
    protected String pilotLycense;
}
