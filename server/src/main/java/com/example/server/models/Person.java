package com.example.server.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table-generator")
    @TableGenerator(name = "table-generator", allocationSize = 1)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String secondName;

    @NonNull
    @Column(nullable = false)
    private int age;

    @NonNull
    @Column(nullable = false)
    private String profession;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
