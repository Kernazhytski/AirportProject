package com.example.server.DTO.person;

import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class AllPersons {
    private List<Pilot> pilots;
    private List<Driver> drivers;
    private List<Stewardess> stewardesses;
}
