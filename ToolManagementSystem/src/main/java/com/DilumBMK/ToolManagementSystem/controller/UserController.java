package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/v1/user")
@CrossOrigin
public class UserController {

     private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/getUser")
    public String getUser(){

        return "Users";
    }


    @PostMapping("/saveUser")
    public String saveUser()
    {
        return "User saved";
    }


    @PutMapping("/updateUser")
    public String updateUser()
    {
        return "User updated";
    }


    @DeleteMapping("/deleteUser")
    public String deleteUser()
    {
        return "user Deleted";
    }





}
