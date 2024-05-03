package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.ToolBoxTool;
import com.BMKCompany.ToolManagementSystem.repository.ToolBoxToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ToolBoxToolController {

    @Autowired
   private ToolBoxToolRepo toolBoxToolRepo;

   @GetMapping("/getToolboxTools")
    public List<ToolBoxTool> getToolBoxTools(){
       return toolBoxToolRepo.findAll();
   }



}
