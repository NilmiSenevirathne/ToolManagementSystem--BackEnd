package com.BMKCompany.ToolManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Location {

    @Id
    private String locationId;
    private String locationName;

    @JsonManagedReference
    @OneToMany(mappedBy = "location")
    private Set<LocationTrack> locationTracks;

    private double latitude;
    private double longitude;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<LocationTrack> getLocationTracks() {
        return locationTracks;
    }

    public void setLocationTracks(Set<LocationTrack> locationTracks) {
        this.locationTracks = locationTracks;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
