package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.Location;
import com.BMKCompany.ToolManagementSystem.model.LocationTrack;

import com.BMKCompany.ToolManagementSystem.Service.ToolBoxService;

import com.BMKCompany.ToolManagementSystem.repository.LocationTrackRepository;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import lombok.Getter;
import lombok.Setter;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolRepo toolRepo;
    @Autowired
    private ToolBoxService toolBoxService;

    @Autowired
    private LocationTrackRepository locationTrackRepository;

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

    //Check toolId already exists in the system
    @GetMapping("/check/{toolId}")
    public ResponseEntity<Map<String,Boolean>> checkToolIdExists(@PathVariable String toolId){
        boolean exists = toolRepo.existsById(toolId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("exists",exists);
        return ResponseEntity.ok(response);
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

    //delete tool details from the inventory
    @DeleteMapping("/delete/{toolId}")
    public ResponseEntity<String> deleteTool(@PathVariable ("toolId") String toolId)
    {
        try{
            Optional<Tool> toolOptional = toolRepo.findById(toolId);
            if(toolOptional.isPresent()){
                toolRepo.deleteById(toolId);
                return ResponseEntity.ok("Tool deleted successfully");
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting tool: "+e.getMessage());
        }
    }


    @GetMapping("/availableTools")
    public ResponseEntity<Integer> calculateAvailableQuantity(){
        List <Tool> allTools = toolRepo.findAll();
        int availableQuantity = 0;
        for(Tool tool: allTools){
            availableQuantity += tool.getQuantity();
        }
        return ResponseEntity.ok(availableQuantity);
    }
    //get tool data to tool inventory chart
    @GetMapping("/toolInventory")
    public ResponseEntity<List<Map<String, Object>>> getToolInventory() {
        List<Map<String, Object>> toolInventory = new ArrayList<>();
        List<Tool> tools = toolRepo.findAll();

        for (Tool tool : tools) {
            Map<String, Object> toolData = new HashMap<>();
            toolData.put("toolId", tool.getToolId());
            toolData.put("toolName", tool.getToolName());
            toolData.put("quantity", tool.getQuantity());
            toolInventory.add(toolData);
        }

        return ResponseEntity.ok(toolInventory);
    }

//    @GetMapping("/{toolId}/locations")
//    public List<Location> getToolLocations(@PathVariable String toolId) {
//        List<LocationTrack> locationTracks = locationTrackRepository.findByToolToolId(toolId);
//        return locationTracks.stream()
//                .map(LocationTrack::getLocation)
//                .distinct()
//                .collect(Collectors.toList());
//    }

    @GetMapping("/{toolId}/locations")
    public ResponseEntity<List<Location>> getToolLocations(@PathVariable String toolId) {
        try {
            List<LocationTrack> locationTracks = locationTrackRepository.findByToolToolId(toolId);
            List<Location> locations = locationTracks.stream()
                    .map(LocationTrack::getLocation)
                    .distinct()
                    .collect(Collectors.toList());
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

}













