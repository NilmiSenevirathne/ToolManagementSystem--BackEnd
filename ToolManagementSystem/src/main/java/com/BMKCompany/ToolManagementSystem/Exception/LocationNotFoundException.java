package com.BMKCompany.ToolManagementSystem.Exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException (String locationId){
        super("Could not found the location with id"+(locationId));
    }

}
