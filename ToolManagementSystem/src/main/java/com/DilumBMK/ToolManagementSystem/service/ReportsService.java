package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.ReportsRepo;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    private final ReportsRepo reportsRepo;

    public ReportsService(ReportsRepo reportsRepo) {
        this.reportsRepo = reportsRepo;
    }
}
