package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.ReportsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }
}
