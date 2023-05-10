package com.example.server.models.persons;

import com.example.server.models.Gender;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Driver extends Person {
    @NonNull

    protected String driverLycense;

    public Driver() {
    }

    public Driver(Long id, String firstName, String secondName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
    }

}
