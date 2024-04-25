package com.BMKCompany.ToolManagementSystem.Exception;

public class ToolNotFoundException extends RuntimeException{

    public ToolNotFoundException(String toolId) {
        super("Could not found the tools details with id "+toolId);
    }
}
