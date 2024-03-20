package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "Reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "report_Id")
    private Long report_Id;

    @Column(name = "reportName")
    private String report_Name;

    @Column(name = "report_Details")
    private String report_Details;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;




}
