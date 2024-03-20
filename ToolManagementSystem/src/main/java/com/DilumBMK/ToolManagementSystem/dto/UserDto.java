package com.DilumBMK.ToolManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String user_Id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private int nic;
    private String userTypeID;
    private int contact;
    private  byte[] pic;
}
