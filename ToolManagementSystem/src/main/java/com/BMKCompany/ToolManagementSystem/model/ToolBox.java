package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "ToolBox")
public class ToolBox {

    @Id
    private String toolbox_id;
    private String project_id;
    private String site_supervisor_id;
    private String Location_id;

    public String getToolbox_id() {
        return toolbox_id;
    }

    public void setToolbox_id(String toolbox_id) {
        this.toolbox_id = toolbox_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getSite_supervisor_id() {
        return site_supervisor_id;
    }

    public void setSite_supervisor_id(String site_supervisor_id) {
        this.site_supervisor_id = site_supervisor_id;
    }

    public String getLocation_id() {
        return Location_id;
    }

    public void setLocation_id(String location_id) {
        Location_id = location_id;
    }
}
