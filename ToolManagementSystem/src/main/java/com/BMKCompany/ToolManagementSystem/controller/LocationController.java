package com.BMKCompany.ToolManagementSystem.controller;
import com.BMKCompany.ToolManagementSystem.model.Location;

import com.BMKCompany.ToolManagementSystem.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/location")
    Location newlocation(@RequestBody Location newlocation){
           return locationRepository.save(newlocation);

    }

    @GetMapping("/locations")
    List<Location> getAllLocations(){return locationRepository.findAll();}



}
