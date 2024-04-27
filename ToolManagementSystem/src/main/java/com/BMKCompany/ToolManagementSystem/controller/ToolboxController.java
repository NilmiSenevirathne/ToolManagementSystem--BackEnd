package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("toolbox")
public class ToolboxController {

    private ToolboxRepo toolboxRepo;

    //retrieve toolbox data from database
    @GetMapping("/gettoolbox")
    public List<ToolBox> getToolbox()
    {
        return toolboxRepo.findAll();
    }
}
