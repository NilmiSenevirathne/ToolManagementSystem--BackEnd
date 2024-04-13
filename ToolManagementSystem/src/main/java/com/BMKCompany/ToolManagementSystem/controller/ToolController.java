package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.exception.ToolNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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


    //get tools details from toolid
    @GetMapping("/gettools/{id}")
    Tool getToolById(@PathVariable String id){
        return toolRepo.findById(id)
                .orElseThrow(() -> new ToolNotFoundException(id) );
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


    }


    //update tool details
    /*@PutMapping("/update/{id}")
    public ResponseEntity<Tool> updateTool(@RequestBody Tool updatedTool, @PathVariable String id) {
        return toolRepo.findById(id)
                .map(tool -> {
                    tool.setToolName(updatedTool.getToolName());
                    tool.setDescription(updatedTool.getDescription());
                    tool.setTotalQuantity(updatedTool.getTotalQuantity());
                    Tool savedTool = toolRepo.save(tool);
                    return ResponseEntity.ok(savedTool);
                }).orElse(ResponseEntity.notFound().build());
    }*/




    


