package com.DilumBMK.ToolManagementSystem.controller;


import com.DilumBMK.ToolManagementSystem.exeption.UserNotFoundException;
import com.DilumBMK.ToolManagementSystem.model.User;

import com.DilumBMK.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;


@Controller
@RestController
@CrossOrigin(origins = "*")
public class UserController {

        @Autowired
        private UserRepository userRepository;


        @PostMapping("/adduser")
        User addUser(@RequestBody User addUser)
        {
            return userRepository.save(addUser);
        }

        @GetMapping("/getusers")
    List<User> getAllUsers()
        {
            return userRepository.findAll();
        }
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id){

        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
            return userRepository.findById(id)
                    .map(user -> {
                        user.setContact(newUser.getContact());
                        user.setFirstname(newUser.getFirstname());
                        user.setLastname(newUser.getLastname());
                        user.setNic(newUser.getNic());
                        user.setPassword(newUser.getPassword());
                        user.setUsername(newUser.getUsername());
                        return userRepository.save(user);
                    }).orElseThrow(()->new UserNotFoundException(id));


        }
    }






