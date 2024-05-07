package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<User> getUserForToolbox() {
        return userRepository.findAll();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable String userid) {
        User user = UserService.getUserById(userid);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = UserService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<User> updateUser(@PathVariable String userid, @RequestBody User updatedUser) {
        User user = UserService.updateUser(userid, updatedUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return ResponseEntity.ok("User with ID " + userid + " has been deleted.");
    }
}


}


