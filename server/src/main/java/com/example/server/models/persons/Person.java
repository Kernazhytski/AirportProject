package com.example.server.models.persons;

import com.example.server.models.Gender;
import com.example.server.models.vehicles.Vehicle;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


@Entity
@Getter
@Setter
@Accessors(chain = true)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table-generator")
    @TableGenerator(name = "table-generator", allocationSize = 1)
    protected Long id;

    @NonNull
    @Column(nullable = false)
    protected String firstName;

    @NonNull
    @Column(nullable = false)
    protected String secondName;

    @NonNull
    @Column(nullable = false)
    protected String age;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    protected Gender gender;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    protected Vehicle vehicle;

    public abstract boolean canWorkWith(String type);
}
