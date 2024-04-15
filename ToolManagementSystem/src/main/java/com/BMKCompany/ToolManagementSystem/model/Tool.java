package com.BMKCompany.ToolManagementSystem.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Tool")
public class Tool {

    @Id
    private String toolId;
    private String toolName;
    private String description;
    private int quantity;


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


}
