package com.BMKCompany.ToolManagementSystem.Exception;

import com.BMKCompany.ToolManagementSystem.model.Locations;

public class LocationsNotFoundException extends RuntimeException {

    public LocationsNotFoundException (String locationId){
        super("Could not found the location with id"+(locationId));
    }

}
