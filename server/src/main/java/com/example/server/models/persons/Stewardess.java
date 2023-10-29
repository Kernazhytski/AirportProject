package com.example.server.models.persons;

import com.example.server.models.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
@ToString
public class Stewardess extends Person {

    @NonNull
    protected String[] languages;

    public Stewardess(Long id, String firstName, String secondName, String age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Stewardess stewardess = (Stewardess) o;
        return id == stewardess.id &&
                ((firstName.equals(stewardess.firstName)) &&
                        (secondName.equals(stewardess.secondName)) &&
                        (age.equals(stewardess.age)));
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, age);
    }
}
