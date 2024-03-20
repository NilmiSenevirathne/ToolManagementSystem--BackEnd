package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.repo.AllocatedToolsRepo;
import com.DilumBMK.ToolManagementSystem.service.AllocatedToolsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/allocatedTools")
public class AllocatedToolsController {

     private final AllocatedToolsService allocatedToolsService;

    public AllocatedToolsController(AllocatedToolsService allocatedToolsService) {
        this.allocatedToolsService = allocatedToolsService;
    }
}
