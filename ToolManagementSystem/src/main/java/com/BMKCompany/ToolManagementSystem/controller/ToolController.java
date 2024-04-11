package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.exception.ToolNotFoundException;
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


    //get tools details from toolid
    @GetMapping("/gettools/{id}")
    Tool getToolById(@PathVariable Long id){
        return toolRepo.findById(id)
                .orElseThrow(() -> new ToolNotFoundException(id) );
    }

    //enter new tool to the database
    @PostMapping("/createtool")
    public Tool newTool(@RequestBody Tool newTool)
    {
        return toolRepo.save(newTool);
    }


    //update tool details
    @PutMapping("/tool/{id}")
    Tool updateTool(@RequestBody Tool newTool , @PathVariable Long id){
        return toolRepo.findById(id)
                .map(tool -> {
                    tool.setToolname(newTool.getToolname());
                    tool.setDescription(newTool.getDescription());
                    tool.setSavedQuantity(newTool.getSavedQuantity());
                    tool.setAllocatedQuantity(newTool.getAllocatedQuantity());
                    return toolRepo.save(tool);
                }).orElseThrow(()-> new ToolNotFoundException(id));
    }

    //delete tool details from the inventory
    @DeleteMapping("/delete/{id}")
    String deleteTool(@PathVariable Long id){
        if(!toolRepo.existsById(id)){
            throw new ToolNotFoundException(id);
        }
        toolRepo.deleteById(id);
        return  "Tool "+id+ "has been deleted success";
    }

    

}
