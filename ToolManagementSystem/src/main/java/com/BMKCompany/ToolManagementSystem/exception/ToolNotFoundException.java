package com.BMKCompany.ToolManagementSystem.exception;

public class ToolNotFoundException extends RuntimeException{

    public ToolNotFoundException(String toolId) {
        super("Could not found the tools details with id "+toolId);
    }
}
