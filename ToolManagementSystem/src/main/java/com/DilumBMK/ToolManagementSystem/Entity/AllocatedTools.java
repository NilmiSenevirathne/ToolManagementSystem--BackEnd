package com.DilumBMK.ToolManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "AllocatedTools")
public class AllocatedTools {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;


    @ManyToMany
    @JoinTable(name = "allocatedToolsSet" , joinColumns = @JoinColumn(name = "allocated_toolId"), inverseJoinColumns = @JoinColumn(name = "tool_Id"))
    @JsonIgnore
    Set<Tools> Tools = new HashSet<>();


    private int allocatedQuantity;
    private int savedQuantity;


}
