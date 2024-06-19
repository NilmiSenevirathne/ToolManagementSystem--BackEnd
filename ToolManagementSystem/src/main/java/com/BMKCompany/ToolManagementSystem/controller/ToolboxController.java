package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("toolbox")
public class ToolboxController {

    private final ToolBoxService toolBoxService;

//    private static final Logger logger = LoggerFactory.getLogger(ToolboxController.class);
    @Autowired
    public ToolboxRepo toolboxRepo;

    @Autowired
    public ToolboxController(ToolBoxService toolBoxService) {
        this.toolBoxService = toolBoxService;
    }
    //retrieve toolbox data from database
    @GetMapping("/gettoolbox")
    public List<ToolBox> getToolbox() {
        return toolboxRepo.findAll();
    }

    // Retrieve toolbox data by ID from the database
    @GetMapping("/{id}")
    public ResponseEntity<?> getToolBoxById(@PathVariable Long id) {
        Optional<ToolBox> toolBox = toolBoxService.getToolBoxById(id);
        if (toolBox.isPresent()) {
            return ResponseEntity.ok(toolBox.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Toolbox not found");
        }
    }

    // Create toolbox
    @PostMapping("/create")
    public ResponseEntity<ToolBox> createToolbox(@RequestBody ToolBox toolBox) {
        ToolBox createdToolBox = toolBoxService.createToolBox(toolBox);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdToolBox);
    }




}
