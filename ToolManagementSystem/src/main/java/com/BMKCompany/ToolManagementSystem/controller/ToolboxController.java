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

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("toolbox")
public class ToolboxController {

    private final ToolBoxService toolBoxService;

    private static final Logger logger = LoggerFactory.getLogger(ToolboxController.class);
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

    //create toolbox function
    @PostMapping("/createtoolbox")
    public ResponseEntity<String> createToolBox(@RequestBody ToolBox toolBox){
        logger.info("Received request to create toolbox: {}");
        toolBoxService.save(toolBox);
        return  new ResponseEntity<>("Toolbox Successfully Created", HttpStatus.CREATED);
    }


}
