package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.UserService;
import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin (origins = "*")
@RequestMapping ("/authentication")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // Endpoint to fetch user details for toolbox creation
    @GetMapping("/getUsertoolbox")
    public List<User> getUserForToolbox() {
        return userRepository.findAll();
    }


    // Endpoint to get user details for editing profile
    @GetMapping("/getUserDetails/{userid}")
    public User getUserDetails(@PathVariable String userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
    }


    @GetMapping("/getUserDetails/{username}")
    public User getUserDetailsINUsername(@PathVariable String username) {
        return userService.getUserDetailsByUsername(username);
    }


    // Endpoint to update user profile
    @PutMapping("/updateUserProfile/{username}")
    public User updateUserProfileByUsername(@PathVariable String username, @RequestBody User updatedUser) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    user.setPassword(updatedUser.getPassword());
                    user.setFirstname(updatedUser.getFirstname());
                    user.setLastname(updatedUser.getLastname());
                    user.setNic(updatedUser.getNic());
                    user.setContact(updatedUser.getContact());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username)); // Handle user not found
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword((userDetails.getPassword())); // Encrypt the password
            user.setFirstname(userDetails.getFirstname());
            user.setLastname(userDetails.getLastname());
            user.setNic(userDetails.getNic());
            user.setContact(userDetails.getContact());
            user.setRole(userDetails.getRole());
//            user.setImageData(userDetails.getImageData());

            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        if (userRepository.existsById(newUser.getUserid())) {
            return ResponseEntity.badRequest().body(null);
        }
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }







}