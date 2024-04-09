package com.DilumBMK.ToolManagementSystem.exeption;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Could not found the uset with id"+id);
    }

}
