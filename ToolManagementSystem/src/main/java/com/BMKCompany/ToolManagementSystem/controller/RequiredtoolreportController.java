package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.Requiredtoolreports;
import com.BMKCompany.ToolManagementSystem.repository.RequiredtoolreportsRepository;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/api/reports")
public class RequiredtoolreportController {
    @Autowired
    ToolRepo toolRepo;

    RequiredtoolreportsRepository requiredtoolreportsRepository;
    @Autowired
    public RequiredtoolreportController(RequiredtoolreportsRepository requiredtoolreportsRepository) {
        this.requiredtoolreportsRepository = requiredtoolreportsRepository;
    }
    @PostMapping
    public ResponseEntity<String> addReportDetails(

            @RequestParam("projectName") String projectName,
            @RequestParam("reportPdf") MultipartFile reportPdf) {
        if (projectName.isEmpty() || reportPdf.isEmpty()) {
            return ResponseEntity.badRequest().body("Project name and report PDF are required.");
        }

        try {
            // Save the report to the database
            Requiredtoolreports report = new Requiredtoolreports();

            report.setProject_name(projectName);
            report.setReport_data(reportPdf.getBytes());
            report.setCreated_at(LocalDateTime.now()); // Set current date and time

            Requiredtoolreports savedReport=requiredtoolreportsRepository.save(report);

            Map<String, Object> response = new HashMap<>();
            response.put("reportId", savedReport.getReport_id());
            response.put("message", "Report details added successfully!");
            return ResponseEntity.ok().body(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save report details.");
        }
    }
    
    //get and view  report details to see the stocksupervisor
    @GetMapping("/getreports")
    public List<Requiredtoolreports> getReports(){
        return requiredtoolreportsRepository.findAll();
    }
    
    
}


