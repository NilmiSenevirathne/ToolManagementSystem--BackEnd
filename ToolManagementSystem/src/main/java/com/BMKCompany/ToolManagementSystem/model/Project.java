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

    private String locationName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    private String StartDate;
    private String EndDate;
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }



    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }




    public String getProjectId() { return projectId;}

    public void setProjectId(String projectId) { this.projectId = projectId;}

    public String getProjectName() { return ProjectName;}

    public void setProjectName(String projectName) { ProjectName = projectName; }

    public String getDescription() { return Description;}

    public void setDescription(String description) { Description = description;}

    public String getSiteSupervisorID() { return SiteSupervisorID; }

    public void setSiteSupervisorID(String siteSupervisorID) { SiteSupervisorID = siteSupervisorID;}

    public String getSiteSupervisorName() { return SiteSupervisorName;}

    public void setSiteSupervisorName(String siteSupervisorName) { SiteSupervisorName = siteSupervisorName;}

    public String getLocationId() { return locationId; }

    public void setLocationId(String locationId) { this.locationId = locationId;}




}

