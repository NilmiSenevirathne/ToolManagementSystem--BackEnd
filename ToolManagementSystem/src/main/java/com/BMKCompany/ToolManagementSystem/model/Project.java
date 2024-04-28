package com.BMKCompany.ToolManagementSystem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class Project {


    @Id
    private String projectId;
    private String ProjectName;

    private String Description;
    private String SiteSupervisorID;
    private String SiteSupervisorName;
    private String locationId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSiteSupervisorID() {
        return SiteSupervisorID;
    }

    public void setSiteSupervisorID(String siteSupervisorID) {
        SiteSupervisorID = siteSupervisorID;
    }

    public String getSiteSupervisorName() {
        return SiteSupervisorName;
    }

    public void setSiteSupervisorName(String siteSupervisorName) {
        SiteSupervisorName = siteSupervisorName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }







}

