package com.example.server.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table-generator")
    @TableGenerator(name = "table-generator", allocationSize = 1)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String type;
    @NonNull
    @Column(nullable = false)
    private String model;
    @NonNull
    @Column(nullable = false)
    private String number;
    @NonNull
    @Column(nullable = false)
    private int crews;
    @NonNull
    @Column(nullable = false)
    private int passengers;
}

