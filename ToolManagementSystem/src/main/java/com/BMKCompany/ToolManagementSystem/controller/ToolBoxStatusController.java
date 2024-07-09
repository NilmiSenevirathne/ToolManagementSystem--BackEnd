package com.BMKCompany.ToolManagementSystem.controller;

import com.BMKCompany.ToolManagementSystem.model.ToolBoxStatus;
import com.BMKCompany.ToolManagementSystem.repository.ToolBoxStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/toolboxstatus")
public class ToolBoxStatusController {

    @Autowired
    private ToolBoxStatusRepository toolBoxStatusRepository;

    // Endpoint to retrieve all tool status reports
    @GetMapping("/getToolstatus")
    public ResponseEntity<List<ToolBoxStatus>> getToolStatusReport() {
        List<ToolBoxStatus> toolBoxStatuses = toolBoxStatusRepository.findAll();
        return new ResponseEntity<>(toolBoxStatuses, HttpStatus.OK);
    }

    // Endpoint to add a new tool status report
    @PostMapping
    public ResponseEntity<Map<String, Object>> addToolStatusDetails(
            @RequestParam("projectName") String projectName,
            @RequestParam("reportPdf") MultipartFile reportPdf) {

        // Check if the required fields are provided
        if (projectName.isEmpty() || reportPdf.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Project name and status PDF are required."));
        }

        try {
            // Create a new ToolBoxStatus object and set its properties
            ToolBoxStatus report = new ToolBoxStatus();
            report.setProjectName(projectName);
            report.setStatusPDF(reportPdf.getBytes());
            report.setCreated_at(LocalDateTime.now());

            // Save the new report to the repository
            ToolBoxStatus savedReport = toolBoxStatusRepository.save(report);

            // Prepare the response with the saved report ID and success message
            Map<String, Object> response = new HashMap<>();
            response.put("reportId", savedReport.getReportId());
            response.put("message", "Report details added successfully!");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Failed to save report details."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "An unexpected error occurred."));
        }
    }

    // Endpoint to delete a tool status report by its ID
    @DeleteMapping("/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
        try {
            // Delete the report from the repository
            toolBoxStatusRepository.deleteById(reportId);
            return ResponseEntity.ok("Report deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete report.");
        }
    }
}
