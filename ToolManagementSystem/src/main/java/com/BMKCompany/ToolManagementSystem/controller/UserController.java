package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.UserService;
import com.BMKCompany.ToolManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to create user profile
    @PostMapping("/createNewUser")
    public ResponseEntity<?> CreateNewUser(@RequestBody User user) {
        try {
            userService.CreateNewUser(user);
            return ResponseEntity.ok("Add User Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong");
        }
    }

<<<<<<< Updated upstream
    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable String userid) {
        User user = UserService.getUserById(userid);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = UserService.createUser(user);
        return ResponseEntity.ok(newUser);
=======
    // Endpoint to fetch all user details
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> GetAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong");
        }
    }

    // Endpoint to get user details by id
    @GetMapping("/getUser/{userid}")
    public ResponseEntity<?> getUserDetails(@PathVariable Integer userid) {
        try {
            return ResponseEntity.ok(userService.getUserById(userid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong");
        }
    }


    // Endpoint to update user profile
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUserProfile(@RequestBody User updatedUser) {
        try {
            userService.updateUser(updatedUser);
            return ResponseEntity.ok("Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.ok().body("Something Went Wrong");
        }
    }

    // Endpoint to delete user profile
    @DeleteMapping("/deleteUser/{userid}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Integer userid) {
        try {
            userService.deleteUser(userid);
            return ResponseEntity.ok("Delete Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong");
        }
>>>>>>> Stashed changes
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


