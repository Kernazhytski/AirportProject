package com.example.server.DBScripts;

import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.repo.DriverRepo;
import com.example.server.repo.GenderRepo;
import com.example.server.repo.PilotRepo;
import com.example.server.repo.StewardessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonDB implements CommandLineRunner {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private PilotRepo pilotRepo;

    @Autowired
    private StewardessRepo stewardessRepo;

    @Autowired
    private GenderRepo genderRepo;

    @Override
    public void run(String... args) throws Exception {
        if (driverRepo.count() == 0) {
            Driver driver = new Driver();
            driver.setAge("16.7.2003");
            driver.setDriverLycense("123");
            driver.setGender(genderRepo.findByGender("Мужской"));
            driver.setFirstName("Andrei");
            driver.setSecondName("Kernazh");
            driverRepo.save(driver);
        }
        if (pilotRepo.count() == 0) {
            Pilot pilot = new Pilot();
            pilot.setAge("1.8.1975");
            pilot.setPilotLycense("322");
            pilot.setGender(genderRepo.findByGender("Мужской"));
            pilot.setFirstName("Vladzimir");
            pilot.setSecondName("Kukovich");
            pilotRepo.save(pilot);
        }
        if (stewardessRepo.count() == 0) {
            Stewardess stewardess = new Stewardess();
            stewardess.setAge("16.7.2003");
            stewardess.setLanguages(new String[]{"Английский","Русский"});
            stewardess.setGender(genderRepo.findByGender("Женский"));
            stewardess.setFirstName("Nataliya");
            stewardess.setSecondName("Shevcova");
            stewardessRepo.save(stewardess);
        }
    }


}
