package com.BMKCompany.ToolManagementSystem.controller;
import com.BMKCompany.ToolManagementSystem.model.Location;

import com.BMKCompany.ToolManagementSystem.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/location")
    Location newlocation(@RequestBody Location newlocation){
           return locationRepository.save(newlocation);

    }




}
