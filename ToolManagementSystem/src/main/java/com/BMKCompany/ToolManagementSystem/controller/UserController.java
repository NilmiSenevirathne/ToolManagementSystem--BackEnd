package com.BMKCompany.ToolManagementSystem.controller;
<<<<<<< Updated upstream
import java.util.List;
=======

>>>>>>> Stashed changes


import com.BMKCompany.ToolManagementSystem.Exception.UserNotFoundException;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@CrossOrigin (origins = "*")
@RequestMapping ("/authentication")

public class UserController {

    @Autowired
    private UserRepository userRepository;
    @DeleteMapping("/deleteUser/{id}")
        String deleteUser(@PathVariable  id){ // Corrected the path variable name to 'id'
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" has been deleted! "; // Added space after 'id'

    }

}
