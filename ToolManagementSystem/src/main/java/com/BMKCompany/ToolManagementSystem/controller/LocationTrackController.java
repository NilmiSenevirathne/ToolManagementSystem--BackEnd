package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.LocationTrack;
import com.BMKCompany.ToolManagementSystem.repository.LocationTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class LocationTrackController {


    @Autowired
    private LocationTrackRepository locationTrackRepository;

    @GetMapping("/tool/{toolId}")
    public List<LocationTrack> getLocationTrackByToolId(@PathVariable String toolId) {
        return locationTrackRepository.findByToolToolId(toolId);
    }


}

