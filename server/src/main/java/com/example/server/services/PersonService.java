package com.example.server.services;


import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.repo.DriverRepo;
import com.example.server.repo.PilotRepo;
import com.example.server.repo.StewardessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<List<?>> response;

    @Autowired
    private PilotRepo pilotRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private StewardessRepo stewardessRepo;

    public void addPilot(Pilot p) {
        pilotRepo.save(p);
    }

    public void addDriver(Driver p) {
        driverRepo.save(p);
    }

    public void addStewardess(Stewardess p) {
        stewardessRepo.save(p);
    }

    public List<List<?>> getList(String job) {
        response = new ArrayList<>();
        if (job.equals("all")) {
            response.add(driverRepo.findAll());
            response.add(pilotRepo.findAll());
            response.add(stewardessRepo.findAll());
        } else {
            switch(job){
                case "pilot" -> response.add(pilotRepo.findAll());
                case "driver" -> response.add(driverRepo.findAll());
                case "stewardess" -> response.add(stewardessRepo.findAll());
                default -> throw new IllegalStateException("Unexpected job: " + job);
            }
        }
        return response;
    }
}
