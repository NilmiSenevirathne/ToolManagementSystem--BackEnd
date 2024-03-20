package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Entity
@Table(name = "ToolBox")
public class ToolBox {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 500)
    private String qr_Id;

    String tool_Id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tool_id" , referencedColumnName = "tool_Id")
    Set<Tools> tools = new HashSet<>();

    @Column(name = "tool_Details")
    private String tool_Details;


    @Column(name = "timestamp")
    private LocalDateTime timestamp;



}
