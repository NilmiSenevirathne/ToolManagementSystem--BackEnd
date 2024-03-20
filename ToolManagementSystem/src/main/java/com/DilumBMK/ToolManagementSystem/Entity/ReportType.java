package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "ReportType")
public class ReportType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportTypeID")
    private Long reportTypeID;

    @Column(name = "reportTypeName")
    private String reportTypeName;


}
