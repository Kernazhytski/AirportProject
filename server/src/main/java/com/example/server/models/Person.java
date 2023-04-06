package com.example.server.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @NonNull
    @Column(nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
