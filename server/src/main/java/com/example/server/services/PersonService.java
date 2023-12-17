package com.example.server.services;


import com.example.server.DTO.persons.*;
import com.example.server.DTO.vehicles.VehicleRequestDTO;
import com.example.server.DTO.vehicles.VehicleResponseDTO;
import com.example.server.models.Gender;
import com.example.server.models.persons.Driver;
import com.example.server.models.persons.Person;
import com.example.server.models.persons.Pilot;
import com.example.server.models.persons.Stewardess;
import com.example.server.models.vehicles.Bus;
import com.example.server.models.vehicles.FettlingMachine;
import com.example.server.models.vehicles.Plane;
import com.example.server.models.vehicles.Vehicle;
import com.example.server.repo.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    List<List<?>> response;

    @Autowired
    private PilotRepo pilotRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private StewardessRepo stewardessRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private PlaneRepo planeRepo;

    @Autowired
    private FettlingMachineRepo fettlingMachineRepo;

    public void addPilot(PilotRequestDTO pilotRequestDTO) {
        Pilot pilot = buildPilotRequest(pilotRequestDTO);
        pilotRepo.save(pilot);
    }

    public void addDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = buildDriverRequest(driverRequestDTO);
        driverRepo.save(driver);
    }

    public void addStewardess(StewardessRequestDTO stewardessRequestDTO) {
        Stewardess stewardess = buildStewardessRequest(stewardessRequestDTO);
        stewardessRepo.save(stewardess);
    }

    @Transactional
    public void  assignWorkerToVehicle(Person person, Vehicle vehicle) {
        if(!person.canWorkWith(vehicle.getType())) {
            throw new IllegalArgumentException("Person cannot work with this type of vehicle");
        }

        if(person.getVehicle() != null) {
            throw new IllegalStateException("Person is already working on another vehicle");
        }

        if(!vehicle.hasSpaceInCrew()) {
            throw new IllegalStateException("Vehicle crews is already full");
        }
        person.setVehicle(vehicle);
        vehicle.setCrews(vehicle.getCrews() + 1);

        if(vehicle instanceof Bus) {
            busRepo.save((Bus) vehicle);
        } else if(vehicle instanceof Plane) {
            planeRepo.save((Plane) vehicle);
        } else if(vehicle instanceof FettlingMachine) {
            fettlingMachineRepo.save((FettlingMachine) vehicle);
        }

        if(person instanceof Pilot) {
            pilotRepo.save((Pilot) person);
        } else if(person instanceof Driver) {
            driverRepo.save((Driver) person);
        } else if(person instanceof Stewardess) {
            stewardessRepo.save((Stewardess) person);
        }
    }

    public Person getPersonById(String type, Long id) {
        return switch (type) {
            case "pilot" -> pilotRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("pilot not found"));
            case "driver" -> driverRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("driver not found"));
            case "stewardess" ->
                    stewardessRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("stewardess not found"));
            default -> throw new IllegalArgumentException("Unexpected type of work");
        };
    }

    public List<List<?>> getList(String job) {
        response = new ArrayList<>();
        if (job.equals("all")) {
            response.add(driverRepo.findAll()
                    .stream()
                    .map(this::buildDriverResponse)
                    .collect(Collectors.toList()));

            response.add(pilotRepo.findAll()
                    .stream()
                    .map(this::buildPilotResponse)
                    .collect(Collectors.toList()));

            response.add(stewardessRepo.findAll()
                    .stream()
                    .map(this::buildStewardessResponse)
                    .collect(Collectors.toList()));
        } else {
            switch(job){
                case "pilot" -> response.add(pilotRepo.findAll()
                        .stream()
                        .map(this::buildPilotResponse)
                        .collect(Collectors.toList()));

                case "driver" -> response.add(driverRepo.findAll()
                        .stream()
                        .map(this::buildDriverResponse)
                        .collect(Collectors.toList()));

                case "stewardess" -> response.add(stewardessRepo.findAll()
                        .stream()
                        .map(this::buildStewardessResponse)
                        .collect(Collectors.toList()));

                default -> throw new IllegalStateException("Unexpected job: " + job);
            }
        }
        return response;
    }

    public DriverResponseDTO buildDriverResponse(Driver driver) {
        return new DriverResponseDTO()
                .setId(driver.getId())
                .setFirstName(driver.getFirstName())
                .setSecondName(driver.getSecondName())
                .setAge(driver.getAge())
                .setGender(new Gender()
                        .setGender(driver.getGender().getGender()))
                .setDriverLycense(driver.getDriverLycense())
                .setVehicleResponseDTO(driver.getVehicle() == null ? null : new VehicleResponseDTO()
                        .setCrews(driver.getVehicle().getCrews())
                        .setType(driver.getVehicle().getType())
                        .setModel(driver.getVehicle().getModel())
                        .setNumber(driver.getVehicle().getNumber()));
    }

    private Driver buildDriverRequest(DriverRequestDTO requestDTO) {
        VehicleRequestDTO vehicleRequestDTO = requestDTO.getBusRequestDTO() == null ? requestDTO.getFettlingMachineRequestDTO() : requestDTO.getBusRequestDTO();
        Vehicle vehicle = null;

        if(vehicleRequestDTO != null) {
            switch (vehicleRequestDTO.getType()) {
                case "bus" -> vehicle = new Bus()
                        .setPassengers(requestDTO.getBusRequestDTO().getPassengers())
                        .setType(vehicleRequestDTO.getType())
                        .setModel(vehicleRequestDTO.getModel())
                        .setNumber(vehicleRequestDTO.getNumber())
                        .setMaxCrewSize(vehicleRequestDTO.getMaxCrewSize());
                case "fettlingMachine" -> vehicle = new FettlingMachine()
                        .setFuelVolume(requestDTO.getFettlingMachineRequestDTO().getFuelVolume())
                        .setType(vehicleRequestDTO.getType())
                        .setModel(vehicleRequestDTO.getModel())
                        .setNumber(vehicleRequestDTO.getNumber())
                        .setMaxCrewSize(vehicleRequestDTO.getMaxCrewSize());
            }
        }

        return (Driver) new Driver()
                .setDriverLycense(requestDTO.getDriverLycense())
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()))
                .setVehicle(vehicle);

    }

    public PilotResponseDTO buildPilotResponse(Pilot pilot) {
        return new PilotResponseDTO()
                .setId(pilot.getId())
                .setFirstName(pilot.getFirstName())
                .setSecondName(pilot.getSecondName())
                .setAge(pilot.getAge())
                .setGender(new Gender()
                        .setGender(pilot.getGender().getGender()))
                .setPilotLycense(pilot.getPilotLycense())
                .setVehicleResponseDTO(pilot.getVehicle() == null ? null : new VehicleResponseDTO()
                        .setCrews(pilot.getVehicle().getCrews())
                        .setType(pilot.getVehicle().getType())
                        .setModel(pilot.getVehicle().getModel())
                        .setNumber(pilot.getVehicle().getNumber()));
    }

    private Pilot buildPilotRequest(PilotRequestDTO requestDTO) {
        return (Pilot) new Pilot()
                .setPilotLycense(requestDTO.getPilotLycense())
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()))
                .setVehicle(requestDTO.getPlaneRequestDTO() == null ? null: new Plane()
                        .setPassengers(requestDTO.getPlaneRequestDTO().getPassengers())
                        .setType(requestDTO.getPlaneRequestDTO().getType())
                        .setModel(requestDTO.getPlaneRequestDTO().getModel())
                        .setNumber(requestDTO.getPlaneRequestDTO().getNumber())
                        .setMaxCrewSize(requestDTO.getPlaneRequestDTO().getMaxCrewSize()));
    }

    public StewardessResponseDTO buildStewardessResponse(Stewardess stewardess) {
        return new StewardessResponseDTO()
                .setId(stewardess.getId())
                .setLanguages(stewardess.getLanguages())
                .setFirstName(stewardess.getFirstName())
                .setSecondName(stewardess.getSecondName())
                .setAge(stewardess.getAge())
                .setGender(new Gender()
                        .setGender(stewardess.getGender().getGender()));
    }

    private Stewardess buildStewardessRequest(StewardessRequestDTO requestDTO) {
        return (Stewardess) new Stewardess()
                .setLanguages(requestDTO.getLanguages())
                .setFirstName(requestDTO.getFirstName())
                .setSecondName(requestDTO.getSecondName())
                .setAge(requestDTO.getAge())
                .setGender(new Gender()
                        .setGender(requestDTO.getGender().getGender()));
    }
}
