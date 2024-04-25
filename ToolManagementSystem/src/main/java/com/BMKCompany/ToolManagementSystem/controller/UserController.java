package com.BMKCompany.ToolManagementSystem.controller;



import com.BMKCompany.ToolManagementSystem.Exception.UserNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.stereotype.Controller;


@Controller
@CrossOrigin("http://localhost:3000")

public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getusers")
    List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    @PostMapping("/adduser")
    User addUser(@RequestBody User addUser)
    {
        return userRepository.save(addUser);
    }



    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {

                    user.setUsername(newUser.getUsername());
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setContact(newUser.getContact());
                    user.setNic(newUser.getNic());
                    user.setRole(newUser.getRole());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/deleteUser/{id}")
    String deleteUser(@PathVariable Long id){ // Corrected the path variable name to 'id'
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" has been deleted! "; // Added space after 'id'

    }
}

