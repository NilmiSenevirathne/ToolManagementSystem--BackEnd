package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "Projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_Id;

    @Column(name = "project_Name")
    private String project_Name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "location_Id")
    private Location location;


}
