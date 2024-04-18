package com.BMKCompany.ToolManagementSystem.model;
import jakarta.persistence.*;

@Entity
public class Tool {

    @Id
    @GeneratedValue
     private Long tool_id;

     private String allocated_quantity;

     private String description;

     private String saved_quantity;

     private String tool_name;


    public Long getToolid() {
        return tool_id;
    }

    public void setTool_id(Long tool_id) {
        this.tool_id= tool_id;
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

    public void setTool_id(String tool_name) {
        this.tool_name= tool_name;
    }


}
