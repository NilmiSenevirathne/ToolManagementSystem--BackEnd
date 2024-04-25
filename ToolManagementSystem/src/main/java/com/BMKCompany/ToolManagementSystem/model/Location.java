package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {

    @Id
    private String locationId;
    private String locationName;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void seLocationName(String LocationName) {
        this.locationName = locationName;
    }
}
