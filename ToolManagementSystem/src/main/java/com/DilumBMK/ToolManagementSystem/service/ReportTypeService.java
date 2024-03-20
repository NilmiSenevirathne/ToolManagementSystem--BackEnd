package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.ReportTypeRepo;
import org.springframework.stereotype.Service;

@Service
public class ReportTypeService {

    private final ReportTypeRepo reportTypeRepo;

    public ReportTypeService(ReportTypeRepo reportTypeRepo) {
        this.reportTypeRepo = reportTypeRepo;
    }
}
