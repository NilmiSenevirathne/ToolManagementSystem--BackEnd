package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.Service.RequiredtoolreportService;
import com.BMKCompany.ToolManagementSystem.model.Requiredtoolreports;
import com.BMKCompany.ToolManagementSystem.model.Tools;
import com.BMKCompany.ToolManagementSystem.repository.RequiredtoolreportsRepository;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class ToolController {

    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private RequiredtoolreportService requiredtoolreportService;

    @GetMapping("/gettools")
    List<Tools> getAllTools() {
        return toolRepository.findAll();
    }

    @PostMapping("/addtool")
    Tools addTools(@RequestBody Tools addTools) {
        return toolRepository.save(addTools);
    }
}


