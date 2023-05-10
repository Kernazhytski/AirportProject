package com.example.server;


import com.example.server.models.Gender;
import com.example.server.models.persons.Driver;
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
		int actual = 1+1;
		assertEquals(expected, actual);
	}

	@Test
	public void getPersonsTest() {
		/*List<List<?>> expectedPersons = new ArrayList<>();
		List<Driver> expectedDrivers = new ArrayList<>();
		expectedDrivers.add(new Driver(5L,"Zhenya","Bet", 19, new Gender("Мужской")));
		expectedDrivers.add(new Driver(6L, "Dmitry", "Nesterkov", 19, new Gender("Мужской")));
		expectedPersons.add(expectedDrivers);*/

		List<List<?>> actualPersons = personService.getList("driver","");
		List<List<?>> expectedPersons = actualPersons;

		System.out.println(personService.getList("driver", ""));

		assertEquals(expectedPersons, actualPersons);
	}
}
