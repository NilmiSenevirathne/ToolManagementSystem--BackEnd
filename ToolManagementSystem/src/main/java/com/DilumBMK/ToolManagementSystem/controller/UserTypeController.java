package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.UserTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userType")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }
}
