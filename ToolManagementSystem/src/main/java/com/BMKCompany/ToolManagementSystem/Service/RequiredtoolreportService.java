package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.Requiredtoolreports;
import com.BMKCompany.ToolManagementSystem.repository.RequiredtoolreportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequiredtoolreportService {
    @Autowired
    private RequiredtoolreportsRepository requiredtoolreportsRepository;
    public Requiredtoolreports saveReport(byte[] reportData, String date, String projectName) {
        Requiredtoolreports requiredtoolreports = new Requiredtoolreports();
        requiredtoolreports.setReport_data(reportData);
        requiredtoolreports.setCreated_at(LocalDateTime.parse(date));
        requiredtoolreports.setProject_name(projectName);
        return requiredtoolreportsRepository.save(requiredtoolreports);
    }

    public List<Requiredtoolreports> getReports() {
        return requiredtoolreportsRepository.findAll();
    }



}


