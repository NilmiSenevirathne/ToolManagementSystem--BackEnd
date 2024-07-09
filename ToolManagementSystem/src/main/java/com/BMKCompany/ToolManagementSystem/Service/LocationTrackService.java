package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.LocationTrack;
import com.BMKCompany.ToolManagementSystem.repository.LocationTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationTrackService {
    @Autowired
    private LocationTrackRepository locationTrackRepository;

    public List<LocationTrack> getLocationTrackByToolId(String toolId) {

        return locationTrackRepository.findByToolToolId(toolId);


    }
}
