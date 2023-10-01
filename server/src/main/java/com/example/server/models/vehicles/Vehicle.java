package com.example.server.models.vehicles;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table-generator")
    @TableGenerator(name = "table-generator", allocationSize = 1)
    protected Integer id;

    @NonNull
    @Column(nullable = false)
    protected String type;
    @NonNull
    @Column(nullable = false)
    protected String model;
    @NonNull
    @Column(nullable = false)
    protected String number;
    @NonNull
    @Column(nullable = false)
    protected int crews;
}

