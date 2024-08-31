package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;
import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/toolbox")
public class ToolboxController {

    private final ToolBoxService toolBoxService;

    //   private static final Logger logger = LoggerFactory.getLogger(ToolboxController.class);
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
    @GetMapping("/search/{toolbox_id}")
    public ResponseEntity<ToolBox> getToolBoxById(@PathVariable("toolbox_id") String toolbox_id) {
        System.out.println("Received toolbox_id: " + toolbox_id);  // Debug statement
        Optional<ToolBox> toolBox = toolboxRepo.findById(toolbox_id);
        return toolBox.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Check toolboxId already exists in the system
    @GetMapping("/check/{toolbox_id}")
    public ResponseEntity<Map<String,Boolean>> checkToolboxIdExists(@PathVariable String toolbox_id){
        boolean exists = toolboxRepo.existsById(toolbox_id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("exists",exists);
        return ResponseEntity.ok(response);
    }


   // create New toolbox
    @PostMapping("/create")
    public ResponseEntity<ToolBox> newToolbox(@RequestBody ToolBox newToolbox) {
        try {
            newToolbox.setCreatedDate(LocalDateTime.now()); // Set current date and time
            ToolBox savedToolbox = toolboxRepo.save(newToolbox);
            System.out.println("Successfully created New Toolbox!");
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





}