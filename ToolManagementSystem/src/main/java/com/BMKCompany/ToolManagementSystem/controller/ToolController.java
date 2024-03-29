package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tool")
public class ToolController {

    @Autowired
     private ToolRepo toolRepo;


    //retrieve tools data from database
    @GetMapping("/gettools")
    public List<Tool> getTools()
    {
        return toolRepo.findAll();
    }

    //enter new tool to the database
    @PostMapping("/createtool")
    public Tool newTool(@RequestBody Tool newTool)
    {
        return toolRepo.save(newTool);
    }

    //update tool details
    

}
