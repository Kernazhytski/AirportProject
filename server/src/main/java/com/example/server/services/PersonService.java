package com.example.server.services;


import com.example.server.DTO.person.AllPersons;
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
    AllPersons allPersons;

    List<List<?>> responce;

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

    public List<List<?>> getList(String job, String fields) {
        responce = new ArrayList<>();
        if (job.equals("all")) {
            /*allPersons = new AllPersons();
            allPersons.setStewardesses(stewardessRepo.findAll());
            allPersons.setDrivers(driverRepo.findAll());
            allPersons.setPilots(pilotRepo.findAll());*/
            responce.add(driverRepo.findAll());
            responce.add(pilotRepo.findAll());
            responce.add(stewardessRepo.findAll());
        } else {
            switch (job){
                case "pilot":
                    responce.add(pilotRepo.findAll());
                    break;
                case "stewardess":
                    responce.add(stewardessRepo.findAll());
                    break;
                case "driver":
                    responce.add(driverRepo.findAll());
                    break;
            }
        }
        return responce;
    }
}
