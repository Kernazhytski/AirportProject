package com.example.server.models.persons;

import com.example.server.models.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Pilot extends Person {

    @NonNull
    protected String pilotLycense;


    public Pilot(Long id, String firstName, String secondName, String age, Gender gender, String pilotLycense) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.pilotLycense = pilotLycense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return id == pilot.id &&
                ((firstName.equals(pilot.firstName)) &&
                        (secondName.equals(pilot.secondName) ) &&
                        (age.equals(pilot.age)) &&
                        (pilotLycense.equals(pilot.pilotLycense)));
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, age, pilotLycense);
    }
}
