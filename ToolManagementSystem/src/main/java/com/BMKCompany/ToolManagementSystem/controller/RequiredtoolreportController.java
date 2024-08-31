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
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reports")
public class RequiredtoolreportController {


    @Autowired
    RequiredtoolreportsRepository requiredtoolreportsRepository;


    @GetMapping("/getReqTool")
    public List<Requiredtoolreports> getRequeredtoolreports() {
        return requiredtoolreportsRepository.findAll();
    }

    @Autowired
    public RequiredtoolreportController(RequiredtoolreportsRepository requiredtoolreportsRepository) {
        this.requiredtoolreportsRepository = requiredtoolreportsRepository;
    }


    @PostMapping
    public ResponseEntity<String> addReportDetails(
            @RequestParam("projectName") String projectName,
            @RequestParam("reportPdf") MultipartFile reportPdf) {

        // Check if the project name or report PDF is empty
        if (projectName.isEmpty() || reportPdf.isEmpty()) {
            return ResponseEntity.badRequest().body("Project name and report PDF are required.");
        }

        try {
            // Save report to the database
            Requiredtoolreports report = new Requiredtoolreports();

            report.setProject_name(projectName);
            report.setReport_data(reportPdf.getBytes());
            report.setCreated_at(LocalDateTime.now());

            Requiredtoolreports savedReport = requiredtoolreportsRepository.save(report);

            // Prepare response
            Map<String, Object> response = new HashMap<>();
            response.put("reportId", savedReport.getReport_id());
            response.put("message", "Report details added successfully!");
            return ResponseEntity.ok().body(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save report details.");
        }
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
        try {
            requiredtoolreportsRepository.deleteById(reportId);
            return ResponseEntity.ok().body("Report deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete report.");
        }
    }

    //get and view  report details to see the stocksupervisor
    @GetMapping("/getreports")
    public List<Requiredtoolreports> getReports(){
        return requiredtoolreportsRepository.findAll();
    }


}
