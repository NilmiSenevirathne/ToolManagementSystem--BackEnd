package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.Entity.Tools;
import com.DilumBMK.ToolManagementSystem.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tools")
public class ToolsController {

    public ToolsController(ToolsService toolsService) {

        this.toolsService = toolsService;
    }

    @Autowired
    private final ToolsService toolsService;


    @PostMapping("/add")
    public String addTools(@RequestBody Tools tools)
    {
        toolsService.saveTools(tools);
        return "New Tool is added to the Inventory";
    }
}
