package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin (origins = "*")
@RequestMapping ("/authentication")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint to fetch user details for toolbox creation
    @GetMapping("/getUsertoolbox")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // Endpoint to get user details for editing profile
    @GetMapping("/getUserDetails/{userid}")
    public User getUserDetails(@PathVariable Long userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
    }


    // Endpoint to update user profile
    @PutMapping("/updateUserProfile/{userid}")
    public User updateUserProfile(@PathVariable Long userid, @RequestBody User updatedUser) {
        return userRepository.findById(userid)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setFirstname(updatedUser.getFirstname());
                    user.setLastname(updatedUser.getLastname());
                    user.setNic(updatedUser.getNic());
                    user.setContact(updatedUser.getContact());
                    user.setImageData(updatedUser.getImageData());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
    }


}


