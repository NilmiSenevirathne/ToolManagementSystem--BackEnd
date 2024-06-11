package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ToolboxController {

    private final ToolBoxService toolBoxService;

    @Autowired
    public ToolboxRepo toolboxRepo;

    @Autowired
    public ToolboxController (ToolBoxService toolBoxService){
        this.toolBoxService = toolBoxService;
    }
    //retrieve toolbox data from database
    @GetMapping("/gettoolbox")
    public List<ToolBox> getToolbox()
    {
        return toolboxRepo.findAll();
    }

    //create toolbox function
    public ResponseEntity<String> createToolBox(@RequestBody ToolBox toolBox){
        return new ResponseEntity<>("Toolbox Successfully Created", HttpStatus.CREATED);
    }
}
