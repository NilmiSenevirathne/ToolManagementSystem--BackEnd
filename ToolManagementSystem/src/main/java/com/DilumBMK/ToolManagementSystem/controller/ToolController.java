package com.DilumBMK.ToolManagementSystem.controller;


import com.DilumBMK.ToolManagementSystem.model.Tools;
import com.DilumBMK.ToolManagementSystem.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

   @PostMapping("/addtool")
   Tools addTool(@RequestBody Tools addTool) {
        return toolRepository.save(addTool);
    }

    @GetMapping("/getTools")
    List<Tools> getAllTools(){
        return toolRepository.findAll();
    }
    }

