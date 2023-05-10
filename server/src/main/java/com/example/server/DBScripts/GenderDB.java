package com.example.server.DBScripts;

import com.example.server.models.Gender;
import com.example.server.repo.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GenderDB implements CommandLineRunner {
    @Autowired
    private GenderRepo genderRepo;

    @Override
    public void run(String... args) throws Exception {
        if (genderRepo.count() == 0) {
            genderRepo.save(new Gender("Мужской"));
            genderRepo.save(new Gender("Женский"));
        }
    }
}
