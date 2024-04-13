package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.exception.ToolNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolRepo toolRepo;


    //retrieve tools data from database
    @GetMapping("/gettools")
    public List<Tool> getTools() {
        return toolRepo.findAll();
    }


    //get tools details from toolid
    @GetMapping("/gettool/{toolId}")
    public ResponseEntity<Tool> getToolById(@PathVariable("toolId") String toolId){
        Optional<Tool> tool = toolRepo.findById(toolId);
        return tool.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //enter new tool to the database
    @PostMapping("/create")
    public ResponseEntity<Tool> newTool(@RequestBody Tool newTool) {
        try {
            Tool savedTool = toolRepo.save(newTool);
            System.out.println("New Tool Successfully Added!");
            return ResponseEntity.ok(savedTool);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Inside updateTool method
    @PutMapping("/update/{toolId}")
    public ResponseEntity<Tool> updateTool(@RequestBody Tool newTool, @PathVariable("toolId") String toolId){

        try {
            Optional<Tool> existingToolOptional = toolRepo.findById(toolId);
            if (existingToolOptional.isPresent()) {
                Tool existingTool = existingToolOptional.get();
                existingTool.setToolName(newTool.getToolName());
                existingTool.setDescription(newTool.getDescription());
                existingTool.setQuantity(newTool.getQuantity());
                Tool updatedTool = toolRepo.save(existingTool);
                return ResponseEntity.ok(updatedTool);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}












