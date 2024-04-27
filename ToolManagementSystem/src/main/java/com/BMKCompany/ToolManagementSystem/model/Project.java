package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {
    @Id
    private String project_id;
    private String description;
    private String project_name;
    private String site_supervisorid;
    private String site_supervisor_name;
    private String location_id;


    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getSite_supervisorid() {
        return site_supervisorid;
    }

    public void setSite_supervisorid(String site_supervisorid) {
        this.site_supervisorid = site_supervisorid;
    }

    public String getSite_supervisor_name() {
        return site_supervisor_name;
    }

    public void setSite_supervisor_name(String site_supervisor_name) {
        this.site_supervisor_name = site_supervisor_name;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }
}
