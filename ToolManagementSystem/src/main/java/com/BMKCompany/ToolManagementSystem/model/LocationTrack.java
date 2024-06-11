package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locationtrack")
public class LocationTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ToolTrackid;

     @ManyToOne
     @JoinColumn(name="locationId" , nullable = false)
     private Location location;

     @ManyToOne
     @JoinColumn(name="toolId" , nullable = false)
     private Tool tool;



    public void setId(Long ToolTrackid) {
        this.ToolTrackid = ToolTrackid;
    }

    public Long getId() {
        return ToolTrackid;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
