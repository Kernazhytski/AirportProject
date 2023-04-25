package com.example.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
public class Gender {
    public Gender(String gender) {
        this.gender = gender;
    }

    public Gender() {
    }

    @Id
    private String gender;
}
