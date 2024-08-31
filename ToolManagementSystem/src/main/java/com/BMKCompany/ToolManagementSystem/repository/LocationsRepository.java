package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationsRepository extends JpaRepository<Locations,String > {

    Optional<Object> findByLocationName(String locationName);
}
