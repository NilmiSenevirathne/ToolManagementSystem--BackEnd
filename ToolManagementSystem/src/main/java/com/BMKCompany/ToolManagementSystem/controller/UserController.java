package com.BMKCompany.ToolManagementSystem.controller;


import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/adduser")
    User addUser(@RequestBody User addUser)
    {
        return userRepository.save(addUser);
    }


}
