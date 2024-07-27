package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Exception.LocationNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Location;
import com.BMKCompany.ToolManagementSystem.model.Locations;
import com.BMKCompany.ToolManagementSystem.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
public class LocationsController {

    @Autowired
    private LocationsRepository locationsRepository;


    private static final Logger LOGGER = Logger.getLogger(LocationsController.class.getName());

    @PostMapping("/location")
    public ResponseEntity<?> newLocation(@RequestBody Locations newLocation) {
        try {
            // Check for duplicate locationId
            if (locationsRepository.existsById(newLocation.getLocationId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Location ID already exists");
            }
            // Check for duplicate locationName
            if (locationsRepository.findByLocationName(newLocation.getLocationName()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Location Name already exists");
            }
            return ResponseEntity.ok(locationsRepository.save(newLocation));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving new location", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving new location");
        }
    }

    @GetMapping("/locations")
    public List<Locations> getAllLocations() {
        try {
            return locationsRepository.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching locations", e);
            throw e;
        }
    }

    @GetMapping("/locations/{locationId}")
    public Locations getLocationById(@PathVariable String locationId) {
        try {
            return locationsRepository.findById(locationId)
                    .orElseThrow(() -> new LocationNotFoundException(locationId));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching location by ID", e);
            throw e;
        }
    }

    @PutMapping("/locations/{locationId}")
    public Locations updateLocation(@RequestBody Locations newLocation, @PathVariable String locationId) {
        try {
            return locationsRepository.findById(locationId)
                    .map(location -> {
                        location.setLocationId(newLocation.getLocationId());
                        location.setLocationName(newLocation.getLocationName());
                        return locationsRepository.save(location);
                    }).orElseThrow(() -> new LocationNotFoundException(locationId));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating location", e);
            throw e;
        }
    }

    @DeleteMapping("/location/{locationId}")
    public String deleteLocation(@PathVariable String locationId) {
        try {
            if (!locationsRepository.existsById(locationId)) {
                throw new LocationNotFoundException(locationId);
            }
            locationsRepository.deleteById(locationId);
            return "Location with ID " + locationId + " has been deleted successfully";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error deleting location", e);
            throw e;
        }
    }

}