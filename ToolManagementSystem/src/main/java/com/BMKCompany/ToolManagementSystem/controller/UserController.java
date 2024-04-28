package com.BMKCompany.ToolManagementSystem.controller;

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




}


