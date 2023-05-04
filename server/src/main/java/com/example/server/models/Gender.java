package com.example.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
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
