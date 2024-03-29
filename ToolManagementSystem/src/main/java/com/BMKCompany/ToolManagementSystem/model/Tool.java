package com.BMKCompany.ToolManagementSystem.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Tool")
public class Tool {

    @Id
    @GeneratedValue
     private Long toolId;

    private String toolname;
    private String description;
    private int savedQuantity;
    private int allocatedQuantity;

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public String getToolname() {

        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSavedQuantity() {
        return savedQuantity;
    }

    public void setSavedQuantity(int savedQuantity) {
        this.savedQuantity = savedQuantity;
    }

    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(int allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }
}
