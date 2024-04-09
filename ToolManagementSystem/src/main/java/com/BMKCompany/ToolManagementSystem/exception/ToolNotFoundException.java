package com.BMKCompany.ToolManagementSystem.exception;

import com.BMKCompany.ToolManagementSystem.model.Tool;

public class ToolNotFoundException extends RuntimeException{

    public ToolNotFoundException(Long toolId) {
        super("Could not found the tools details with id "+toolId);
    }
}
