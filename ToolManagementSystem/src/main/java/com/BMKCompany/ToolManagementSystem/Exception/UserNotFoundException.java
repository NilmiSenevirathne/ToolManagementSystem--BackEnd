package com.BMKCompany.ToolManagementSystem.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userid) {
        super("Could not found the user with id "+userid);
    }
}
