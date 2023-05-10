package com.example.server.controllers;

import com.example.server.models.Gender;
import com.example.server.models.Vehicle;
import com.example.server.models.persons.Driver;
import com.example.server.repo.DriverRepo;
import com.example.server.repo.PilotRepo;
import com.example.server.services.PersonService;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)

class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PilotRepo pilotRepo;
    @MockBean
    private DriverRepo driverRepo;
    @MockBean
    private PersonService personService;

    @Test
    void getPersons() throws Exception {
        /*when(driverRepo.findAll()).thenReturn(Arrays.asList(
        //when(personService.getList("driver", "")).thenReturn((List<Driver>)Arrays.asList(
                new Driver(5L,"Zhenya","Bet", 19, new Gender("Мужской")),
                new Driver(6L, "Dmitry", "Nesterkov", 19, new Gender("Мужской"))
        ));*/

        mockMvc.perform(get("/person/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(5,6)))
                .andExpect(jsonPath("$[*].firstName", containsInAnyOrder("Zhenya", "Dmitry")));
    }
}