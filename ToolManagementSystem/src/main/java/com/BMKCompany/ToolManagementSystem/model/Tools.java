package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Entity
public class Tools {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private String tool_id;

    private byte[] pic;
    private String allocated_quantity;

    private String description;

    private String saved_quantity;

    private String tool_name;


    public String getToolid() {
        return tool_id;
    }
    public void setToolid(String tool_id) {
        this.tool_id= tool_id;
    }
    public byte[] getImage() {
        return pic;
    }
    public void setImage(byte[] pic) {
        this.pic = pic;
    }

    public String getAllocated_quantity() {
        return allocated_quantity;
    }

    public void setAllocated_quantity(String allocated_quantity) {
        this.allocated_quantity= allocated_quantity;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getSaved_quantity() {
        return saved_quantity;
    }

    public void setSaved_quantity(String saved_quantity) {
        this.saved_quantity= saved_quantity;
    }

    public String getTool_name() {
        return tool_name;
    }

    public void setTool_name(String tool_name) {
        this.tool_name= tool_name;
    }

}
