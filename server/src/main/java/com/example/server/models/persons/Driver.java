package com.example.server.models.persons;

import com.example.server.models.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
@ToString
public class Driver extends Person {
    @NonNull
    protected String driverLycense;

    public Driver() {
    }

    public Driver(Long id, String firstName, String secondName, String age, Gender gender, String driverLlycence) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.driverLycense = driverLlycence;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id &&
                ((firstName.equals(driver.firstName)) &&
                        (secondName.equals(driver.secondName)) &&
                        (age.equals(driver.age)) &&
                        (driverLycense.equals(driver.driverLycense)));
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, age, driverLycense);
    }

}
