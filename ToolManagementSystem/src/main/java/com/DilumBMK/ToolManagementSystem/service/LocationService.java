package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.LocationRepo;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }
}
