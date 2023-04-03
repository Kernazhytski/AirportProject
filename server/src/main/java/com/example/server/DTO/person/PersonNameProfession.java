package com.example.server.DTO.person;

import com.example.server.serializer.PersonNameProfessionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonSerialize(using = PersonNameProfessionSerializer.class)
public class PersonNameProfession {
    private long id;
    private String firstName;
    private String secondName;
    private String profession;
}
