package com.example.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain=true)
public class Gender {
    public Gender(String gender) {
        this.gender = gender;
    }

    public Gender() {
    }

    @Id
    private String gender;
}
