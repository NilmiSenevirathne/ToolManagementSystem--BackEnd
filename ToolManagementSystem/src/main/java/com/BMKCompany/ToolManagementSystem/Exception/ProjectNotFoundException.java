package com.BMKCompany.ToolManagementSystem.Exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String projectId){
        super("Could not found the project with id" +(projectId));
    }

}
