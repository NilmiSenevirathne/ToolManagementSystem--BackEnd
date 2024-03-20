package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.ReportTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reportType")
public class ReportTypeController {

    private final ReportTypeService reportTypeService;

    public ReportTypeController(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }
}
