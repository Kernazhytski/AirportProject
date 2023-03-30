package com.example.server.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleController {

}
