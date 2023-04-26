package com.example.server.serializer;

import com.example.server.DTO.person.PersonNameProfession;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PersonNameProfessionSerializer extends JsonSerializer<PersonNameProfession> {
    @Override
    public void serialize(PersonNameProfession personNameProfession, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("firstName", personNameProfession.getFirstName());
        jsonGenerator.writeStringField("profession", personNameProfession.getProfession());
        jsonGenerator.writeNumberField("id", personNameProfession.getId());
        jsonGenerator.writeStringField("secondName", personNameProfession.getSecondName());
        jsonGenerator.writeEndObject();
    }
}