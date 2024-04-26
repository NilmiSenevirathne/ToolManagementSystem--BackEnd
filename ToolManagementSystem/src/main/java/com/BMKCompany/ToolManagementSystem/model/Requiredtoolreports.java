package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name="requiredtoolreports")
public class Requiredtoolreports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_id;

    @Lob
    @Column(name = "report_data", columnDefinition = "LONGBLOB")
    private byte[] report_data;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "project_name")
    private String project_name;


    public Long getReport_id() {
        return report_id;
    }

    public void setReport_id(Long report_id) {
        this.report_id = report_id;
    }

    public byte[] getReport_data() {
        return report_data;
    }

    public void setReport_data(byte[] report_data) {
        this.report_data = report_data;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_name() {
        return project_name;
    }
}
