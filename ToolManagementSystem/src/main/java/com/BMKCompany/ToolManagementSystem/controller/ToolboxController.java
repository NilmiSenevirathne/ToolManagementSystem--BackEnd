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

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("toolbox")
public class ToolboxController {

    private final ToolBoxService toolBoxService;

//    private static final Logger logger = LoggerFactory.getLogger(ToolboxController.class);
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
    @PostMapping("/createToolbox")
    public ResponseEntity<String> createToolbox(@RequestParam("toolbox_id")String toolbox_id, @RequestParam("project_id") String project_id, @RequestParam("site_supervisor_id") String site_supervisor_id, @RequestParam("Location_id")  String Location_id, @RequestParam("selectedTools") String selectedTools){

        //check the fields are empty
        if(toolbox_id.isEmpty() || project_id.isEmpty() || site_supervisor_id.isEmpty() || Location_id.isEmpty() || selectedTools.isEmpty()){
            return ResponseEntity.badRequest().body("All fields fill required ");
        }

        //save details in database
        ToolBox toolBox = new ToolBox();
        toolBox.setToolbox_id(toolbox_id);
        toolBox.setProject_id(project_id);
        toolBox.setSite_supervisor_id(site_supervisor_id);
        toolBox.setLocation_id(Location_id);
        toolBox.setSelectedTools(Collections.singletonList(selectedTools));

        ToolBox savedtoolbox = toolboxRepo.save(toolBox);

        //prepare response
        Map<String, Object> response  = new HashMap<>();
        response.put("toolbox_id", savedtoolbox.getToolbox_id());
        System.out.println("Toolbox Created Successfully!");

        return ResponseEntity.ok().body(response.toString());
    }

}
