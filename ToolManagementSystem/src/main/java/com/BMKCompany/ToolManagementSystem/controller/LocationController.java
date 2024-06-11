package com.BMKCompany.ToolManagementSystem.controller;
import com.BMKCompany.ToolManagementSystem.Exception.LocationNotFoundException;
import com.BMKCompany.ToolManagementSystem.Exception.ProjectNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Location;

import com.BMKCompany.ToolManagementSystem.model.Project;
import com.BMKCompany.ToolManagementSystem.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/location")
    Location newlocation(@RequestBody Location newlocation) {
        return locationRepository.save(newlocation);

    }

    @GetMapping("/locations")
    List<Location> getAllLocations() {
        return locationRepository.findAll();
    }


    @GetMapping("/locations/{locationId}")
    Location getLocationById(@PathVariable String locationId){
        return locationRepository.findById(String.valueOf(locationId))
                .orElseThrow(()->new LocationNotFoundException(locationId));
    }



    @PutMapping("/locations/{locationId}")
    Location UpdateLocation(@RequestBody Location newLocation,@PathVariable String locationId){
        return  locationRepository.findById(locationId)
                .map(Location-> {
                            Location.setLocationId(newLocation.getLocationId());
                            Location.setLocationName(newLocation.getLocationName());
                            return locationRepository.save(Location);
                        }).orElseThrow(()-> new LocationNotFoundException(locationId));
    }


    @DeleteMapping("/location/{locationId}")
    String DeleteLocation(@PathVariable String locationId){
        if(!locationRepository.existsById(locationId)){
            throw new LocationNotFoundException(locationId);
        }
        locationRepository.deleteById(locationId);
        return "location with id"+locationId +"has been deleted successfully";
    }

}
