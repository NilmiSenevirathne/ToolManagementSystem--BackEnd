package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.LocationTrack;
import com.BMKCompany.ToolManagementSystem.repository.LocationTrackRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class LocationTrackController {

    @Autowired
    private LocationTrackRepository locationTrackRepository;


}
