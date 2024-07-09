package com.BMKCompany.ToolManagementSystem.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Tool")
public class Tool {

    @Id
    private String toolId;
    private String toolName;
    private String description;
    private int quantity;
    private int allocatedTool;
    private int availableTool;

    @ManyToOne
    @JoinColumn(name = "toolbox_id")
    private ToolBox toolBox;
    @JsonIgnore
    @OneToMany(mappedBy = "tool")
    private Set<LocationTrack> locationTracks;

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAllocatedTool() {
        return allocatedTool;
    }

    public void setAllocatedTool(int allocatedTool) {
        this.allocatedTool = allocatedTool;
    }

    public int getAvailableTool() {
        return availableTool;
    }

    public void setAvailableTool(int availableTool) {
        this.availableTool = availableTool;
    }

    public ToolBox getToolBox() {
        return toolBox;
    }

    public void setToolBox(ToolBox toolBox) {
        this.toolBox = toolBox;
    }

    public Set<LocationTrack> getLocationTracks() {
        return locationTracks;
    }

    public void setLocationTracks(Set<LocationTrack> locationTracks) {
        this.locationTracks = locationTracks;
    }
}
