package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin("http://localhost:3000")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

    @GetMapping("/gettools")
    List<Tool> getAllTools()
    {
        return toolRepository.findAll();
    }
    @PostMapping("/addtool")
    Tool addTools(@RequestBody Tool addTools)
    {
        return toolRepository.save(addTools);
    }

}
