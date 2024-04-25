package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {

    @Id
    private String locationId;
    private String getLocationName;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getGetLocationName() {
        return getLocationName;
    }

    public void setGetLocationName(String getLocationName) {
        this.getLocationName = getLocationName;
    }
}
