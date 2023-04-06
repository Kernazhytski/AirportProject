package com.example.server.controllers;

import com.example.server.DTO.person.PersonNameProfession;
import com.example.server.models.Person;
import com.example.server.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {
    @Autowired
    private Environment env;
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Person personRequest) {
        personService.addPerson(personRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "job", defaultValue = "all") String job,
                                        @RequestParam(value = "fields", defaultValue = "all") String fields) {
        return new ResponseEntity<>(personService.getList(job, fields), HttpStatus.OK);
    }
}
