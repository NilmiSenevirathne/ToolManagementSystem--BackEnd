package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.model.Tools;
import com.DilumBMK.ToolManagementSystem.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tools")
public class ToolsController {


    @Autowired
    private final ToolsService toolsService;

    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @PostMapping("/add")
    public String addTools(@RequestBody Tools tools)
    {
        toolsService.saveTools(tools);
        return "New Tool is added to the Inventory";
    }


    @GetMapping("/getTools")
    public List<Tools> getAllTools()
    {
        return toolsService.getAllTools();
    }


}
