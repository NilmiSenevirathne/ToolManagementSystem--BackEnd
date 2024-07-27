package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class ToolBoxStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportId")
    private Long ReportId;

    private String ProjectName;
    @Lob
    @Column(name = "statuspdf", columnDefinition = "LONGBLOB")
    private byte[] statusPDF;

    private LocalDateTime created_at;

    // Getters and Setters
    public byte[] getStatusPDF() {
        return statusPDF;
    }

    public void setStatusPDF(byte[] statusPDF) {
        this.statusPDF = statusPDF;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public Long getReportId() {
        return ReportId;
    }

    public void setReportId(Long reportId) {
        ReportId = reportId;
    }
}
