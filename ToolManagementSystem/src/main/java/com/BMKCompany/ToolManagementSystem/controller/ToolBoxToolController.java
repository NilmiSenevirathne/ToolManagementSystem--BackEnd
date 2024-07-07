package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.ToolBoxTool;
import com.BMKCompany.ToolManagementSystem.repository.ToolBoxToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ToolBoxToolController {

    @Autowired
   private ToolBoxToolRepo toolBoxToolRepo;

   @GetMapping("/getToolboxTools")
    public List<ToolBoxTool> getToolBoxTools(){
       return toolBoxToolRepo.findAll();
   }

   //stock supervisor add tool to toolbox
    @PostMapping("/addTooltoToolbox")
    public String addToToolBox(@RequestBody ToolBoxTool toolBoxTool) {
        try {
            toolBoxToolRepo.save(toolBoxTool);
            return "Tool added to ToolBox successfully!";
        } catch (Exception e) {
            return "Error adding tool to ToolBox: " + e.getMessage();
        }
    }

}
