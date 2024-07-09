package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.Location;
import com.BMKCompany.ToolManagementSystem.model.LocationTrack;
import com.BMKCompany.ToolManagementSystem.repository.LocationTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolLocationService {

    @Autowired
    private LocationTrackRepository locationTrackRepository;

    public List<Location> getLocationsByToolId(String toolId) {
        List<LocationTrack> locationTracks = locationTrackRepository.findByToolToolId(toolId);
        return locationTracks.stream()
                .map(LocationTrack::getLocation)
                .collect(Collectors.toList());
    }
}
