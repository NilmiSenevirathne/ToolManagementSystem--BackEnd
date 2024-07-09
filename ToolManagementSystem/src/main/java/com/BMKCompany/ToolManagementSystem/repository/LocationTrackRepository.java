package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Location;
import com.BMKCompany.ToolManagementSystem.model.LocationTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationTrackRepository extends JpaRepository<LocationTrack, Long> {

    List<LocationTrack> findByToolToolId(String tool);


}
