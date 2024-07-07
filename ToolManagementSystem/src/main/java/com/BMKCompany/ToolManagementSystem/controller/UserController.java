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
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Something Went Wrong: " + e.getMessage());
        }
    }


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
    public ResponseEntity<?> getUserDetails(@PathVariable Long userid) {
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

    // Endpoint to fetch user details for toolbox creation
    @GetMapping("/getUsertoolbox")
    public List<User> getUser() {
        return userRepository.findAll();

    // Endpoint to delete user profile
    @DeleteMapping("/deleteUser/{userid}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long userid) {
        try {
            userService.deleteUser(userid);
            return ResponseEntity.ok("Delete Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong");
        }

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


