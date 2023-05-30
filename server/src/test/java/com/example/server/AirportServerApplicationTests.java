package com.example.server;


import com.example.server.models.Gender;
import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class AirportServerApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    public void testSomething() {
        int expected = 2;
        int actual = 1 + 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getDriverTest() {
        Driver expectedDriver = new Driver(9L, "Andrei", "Kernazh", "16.7.2003", new Gender("Мужской"), "123");
        List<List<?>> actualPersons = personService.getList("driver", "");

        List<?> drivers = actualPersons.get(0);
        for(Object driver:drivers){
            if(driver instanceof Driver){
                assertEquals(expectedDriver, driver);
            }
        }

        System.out.println(personService.getList("driver", ""));
    }

    @Test
    public void getPilotTest() {
        Pilot expectedPilot = new Pilot(10L, "Nataliya", "Shevcova", "1.8.1975", new Gender("Мужской"), "322");

        List<List<?>> actualPersons = personService.getList("pilot", "");

        List<?> pilots = actualPersons.get(0);
        for(Object pilot:pilots){
            if(pilot instanceof Pilot){
                assertEquals(expectedPilot, pilot);
            }
        }

        System.out.println(personService.getList("pilot", ""));
    }
    @Test
    public void getStewardess() {
        Stewardess expectedStewardess = new Stewardess(11L, "Andrei", "Kernazh", "16.7.2003", new Gender("Женский"));

        List<List<?>> actualPersons = personService.getList("stewardess", "");

        List<?> stewardesses = actualPersons.get(0);
        for(Object stewardess: stewardesses) {
            if(stewardess instanceof Stewardess) {
                assertEquals(expectedStewardess, stewardess);
            }
        }
    }

}
