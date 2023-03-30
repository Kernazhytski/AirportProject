package com.example.server.controllers;

import com.example.server.models.Person;
import com.example.server.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Person personRequest) {
        personService.addPerson(personRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAll(@RequestParam(value = "job",defaultValue = "all") String job) {
        return new ResponseEntity<>(personService.getList(job),HttpStatus.OK);
    }
}
