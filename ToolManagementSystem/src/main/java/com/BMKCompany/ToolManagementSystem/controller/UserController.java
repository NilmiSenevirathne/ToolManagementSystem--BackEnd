package com.BMKCompany.ToolManagementSystem.controller;
import java.util.List;


import com.BMKCompany.ToolManagementSystem.Exception.UserNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller





@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/authentication")
public class UserController {

    @Autowired
    private UserRepository userRepository;

}
