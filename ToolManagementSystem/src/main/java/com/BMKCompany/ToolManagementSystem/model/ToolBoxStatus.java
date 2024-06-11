package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ToolBoxStatus")
public class ToolBoxStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ToolBoxId;

    private LocalDateTime created_at;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] StatusPDF;


    public byte[] getStatusPDF() {
        return StatusPDF;
    }

    public void setStatusPDF(byte[] statusPDF) {
        StatusPDF = statusPDF;
    }

    public Long getToolBoxId() {
        return ToolBoxId;
    }

    public void setToolBoxId(Long toolBoxId) {
        ToolBoxId = toolBoxId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
