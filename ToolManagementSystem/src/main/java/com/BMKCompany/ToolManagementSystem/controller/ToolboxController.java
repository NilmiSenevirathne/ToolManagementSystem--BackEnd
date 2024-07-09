package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.Tool;
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



    private static final Logger logger = LoggerFactory.getLogger(ToolboxController.class);

    @Autowired
    public ToolboxRepo toolboxRepo;
    @Autowired
    private ToolBoxService toolBoxService;


    //retrieve toolbox data from database
    @GetMapping("/gettoolbox")
    public List<ToolBox> getToolbox() {
        return toolboxRepo.findAll();
    }

    //create toolbox function
    @PostMapping("/createtoolbox")
    public ResponseEntity<String> createToolBox(@RequestBody ToolBox toolBox){
        logger.info("Received request to create toolbox: {}");
        toolBoxService.save(toolBox);
        return  new ResponseEntity<>("Toolbox Successfully Created", HttpStatus.CREATED);
    }



    // Retrieve toolbox data by ID from the database
    @GetMapping("/{id}")
    public ResponseEntity<ToolBox> getToolBoxById(@PathVariable("toolbox_id") String toolbox_id){
        Optional<ToolBox> toolBox = toolboxRepo.findById(toolbox_id);
        return toolBox.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }


     //Create new  toolbox
    @PostMapping("/create")
    public ResponseEntity<ToolBox> newToolbox(@RequestBody ToolBox newToolbox){
        try {
            ToolBox savedToolbox = toolboxRepo.save(newToolbox);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedToolbox);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //delete toolbox details from the inventory
    @DeleteMapping("/delete/{toolbox_id}")
    public ResponseEntity<String> deleteTool(@PathVariable ("toolbox_id") String toolbox_id)
    {
        try{
            Optional<ToolBox> toolboxOptional = toolboxRepo.findById(toolbox_id);
            if(toolboxOptional.isPresent()){
                toolboxRepo.deleteById(toolbox_id);
                return ResponseEntity.ok("Toolbox deleted successfully");
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting tool: "+e.getMessage());
        }
    }

    //update toolbox details
    @PutMapping("/update/{toolbox_id}")
    public ResponseEntity<ToolBox> updateToolbox(@RequestBody ToolBox newToolbox, @PathVariable("toolbox_id") String toolbox_id){

        try {
            Optional<ToolBox> existingToolboxOptional = toolboxRepo.findById(toolbox_id);
            if (existingToolboxOptional.isPresent()) {
                ToolBox existingToolbox = existingToolboxOptional.get();
                existingToolbox.setProject_id(newToolbox.getProject_id());
                existingToolbox.setSite_supervisor_id(newToolbox.getSite_supervisor_id());
                existingToolbox.setLocation_id(newToolbox.getLocation_id());
                ToolBox updatedToolbox = toolboxRepo.save(existingToolbox);
                return ResponseEntity.ok(updatedToolbox);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Retrieve toolbox by ID
    @GetMapping("/{toolbox_id}")
    public ResponseEntity<ToolBox> getToolboxById(@PathVariable("toolbox_id") String toolbox_id) {
        Optional<ToolBox> toolbox = toolboxRepo.findById(toolbox_id);
        return toolbox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



}
