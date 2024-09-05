package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.UserService;
import com.BMKCompany.ToolManagementSystem.model.Role;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        List<User> users = userService.getAllUsers();
        return userRepository.findAll();
    }


    // Endpoint to get user details for editing profile
    @GetMapping("/getUserDetails/{userid}")
    public User getUserDetails(@PathVariable String userid) {
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userid));
    }


    // Endpoint to get user details by username
    @GetMapping("/getUserInfo/{username}")
    public ResponseEntity<User> getUserDetailsByUsername(@PathVariable("username") String username) {
        User user = userService.getUserDetailsByUsername(username);
        return ResponseEntity.ok(user);
    }





    // Endpoint to update user profile
    @PutMapping(value = "/updateUserProfile/{username}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateUserProfileByUsername(
            @PathVariable String username,
            @RequestParam("contact") Long contact,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("gender") String gender,
            @RequestParam("nic") String nic,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("role") Role role,
            @RequestParam("username") String updatedUsername,
            @RequestParam(value = "userimageData", required = false) MultipartFile userimageData) {

        return userRepository.findByUsername(username)
                .map(user -> {
                    user.setContact(contact);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setGender(gender);
                    user.setNic(nic);
                    user.setPassword(password);
                    user.setRole(role);
                    user.setUsername(updatedUsername);

                    // Handle the image upload (if present)
                    if (userimageData != null && !userimageData.isEmpty()) {
                        try {
                            byte[] imageBytes = userimageData.getBytes();
                            user.setImageData(imageBytes); // Assuming you store the image as byte[]
                        } catch (Exception e) {
                            return ResponseEntity.badRequest().body("Error processing image file");
                        }
                    }

                    userRepository.save(user);
                    System.out.println("User profile updated successfully for username: " + username);
                    return ResponseEntity.ok("User profile updated successfully");
                })
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
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


    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<User> updateUser(
            @PathVariable String id,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("gender") String gender,
            @RequestParam("nic") String nic,
            @RequestParam("contact") Long contact,
            @RequestParam("role") Role role,
            @RequestParam("userimageData") MultipartFile userimageData) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(username);
            user.setPassword(password); // Encrypt the password here
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setGender(gender);
            user.setNic(nic);
            user.setContact(contact);
            user.setRole(role);

            try {
                if (userimageData != null && !userimageData.isEmpty()) {
                    user.setUserimageData(userimageData.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

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
    public ResponseEntity<String> createUser(
            @RequestParam("userid") String userid,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("gender") String gender,
            @RequestParam("nic") String nic,
            @RequestParam("contact") Long contact,
            @RequestParam("role") Role role,
            @RequestParam("userimageData") MultipartFile userimageData // Changed to MultipartFile
    ) {
        // Create and save user entity here

        User newUser = new User();
        newUser.setUserid(userid);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstname(firstname);
        newUser.setLastname(lastname);
        newUser.setGender(gender);
        newUser.setNic(nic);
        newUser.setContact(contact);
        newUser.setRole(role);

        // Handle file upload
        try {
            if (userimageData != null && !userimageData.isEmpty()) {
                newUser.setUserimageData(userimageData.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing image.");
        }

        // Check if user already exists
        if (userRepository.existsById(newUser.getUserid())) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        // Save the new user
        User savedUser = userRepository.save(newUser);
        System.out.println("User Details updated successfully !");
        return ResponseEntity.ok("User registered successfully!");
    }







}